package controller.dto;

import com.yubico.webauthn.CredentialRepository;
import com.yubico.webauthn.RegisteredCredential;
import com.yubico.webauthn.data.ByteArray;
import com.yubico.webauthn.data.PublicKeyCredentialDescriptor;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class InMemoryCredentialRepository implements CredentialRepository {

    private final Map<String, List<RegisteredCredential>> credentialStore = new ConcurrentHashMap<>();

    @Override
    public Set<PublicKeyCredentialDescriptor> getCredentialIdsForUsername(String username) {
        return credentialStore.getOrDefault(username, Collections.emptyList())
                .stream()
                .map(credential -> PublicKeyCredentialDescriptor.builder()
                        .id(credential.getCredentialId())
                        .build())
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<ByteArray> getUserHandleForUsername(String username) {
        return credentialStore.containsKey(username)
                ? Optional.of(new ByteArray(username.getBytes()))
                : Optional.empty();
    }

    @Override
    public Optional<String> getUsernameForUserHandle(ByteArray userHandle) {
        return Optional.of(new String(userHandle.getBytes()));
    }

    @Override
    public Optional<RegisteredCredential> lookup(ByteArray credentialId, ByteArray userHandle) {
        String username = new String(userHandle.getBytes());
        return credentialStore.getOrDefault(username, Collections.emptyList())
                .stream()
                .filter(credential -> credential.getCredentialId().equals(credentialId))
                .findFirst();
    }

    @Override
    public Set<RegisteredCredential> lookupAll(ByteArray byteArray) {
        return Collections.emptySet();
    }

    public void addCredential(String username, RegisteredCredential credential) {
        credentialStore.computeIfAbsent(username, k -> new ArrayList<>()).add(credential);
    }

    @Getter
    public static class Credential {
        private final ByteArray credentialId;
        private final ByteArray publicKey;

        public Credential(ByteArray credentialId, ByteArray publicKey) {
            this.credentialId = credentialId;
            this.publicKey = publicKey;
        }

    }
}