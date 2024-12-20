package test;

import com.alibaba.excel.util.StringUtils;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:9/18/24 09:27 <br/>
 */
public class MyTest {
    public static void main(String[] args) {
        String str = "1.完成项目管理平台权限统一调度处理\t\"1.数现大屏总结方案\n" +
                "2.测试边端平台，并提交沟通相关bug(工作流内容重复、审批时间不正确等问题)\n" +
                "3.玉衡平台线上支持\"\t\"1.项目管理平台账号类型异常处理\n" +
                "2.协助新质办公项目技术框架第三方组件整合\"\t\"1.测试边端功能提出禅道bug:经测试发现应用管理审批\n" +
                "流的流转信息显示异常，且组织多人进行\n" +
                "问题排查\"\t1.测试生产环境提出禅道bug：系统菜单显示非正常图标，且后台配置无异常\t\t\t\"1.录制并制作数现大屏的使用方式\n" +
                "2.讨论并整理部分组件中心开发需求计划\"\t\"1.研发计划组件中心、日程会议中心、个人配置中心需求细化讨论\n" +
                "2.玉衡平台技术支持\"\t\"1.国家课题船舶调度移动端外网反向代理调试配置\n" +
                "2.协助开发人员调试外网访问\n" +
                "3.沟通日程会议中心开发需求\"\t\"1.船舶调度前端开发技术支持\n" +
                "2.日程会议中心部分数据库表结构设计\n" +
                "3.玉衡平台应用管理-人员授权处测试发现bug，联系相关人员协助处理\"\t\"1.玉衡平台生产环境-网关系统就异常问题与宝信人员沟通解决\n" +
                "2.内控平台反向代理设置，并协助沟通网络部开通相关地址网段\n" +
                "\"\t\t\t1.日程会议中心开发主表增删改查接口，调用平台端接口完善用户信息数据\t1.数字化审计项目组对于玉衡平台框架远程视频演示沟通项目需求适应性\t\"1.日程会议中心详细设计文档编写\n" +
                "2.日程相关接口开发\"\t\"1.项目月报系统需求讨论\n" +
                "2.项目月报系统数据库表结构设计\n" +
                "3.开发部分接口\"\t\"1.月报系统开发接口\n" +
                "2.跟前端调试接口\n" +
                "3.字典表新增数据\"\t\t\t\"1.解决流水线动态打包发版User模块报错问题\n" +
                "2.跟前端对接项目接口以及字段\n" +
                "3.调整部分逻辑及字段\"\t\"1.月报系统bug解决\n" +
                "2.部分接口功能性优化\n" +
                "3.发布正式环境、正式数据库、以及正式库数据调整、导入\"\t\"1.玉衡boot后端框架调试运行\n" +
                "2.发现并解决mysql版本初始化脚本数据错误问题、部分框架业务代码优化处理\"\t\"1.新质办公工作流以及用户体系技术支持\n" +
                "2.玉衡平台boot版本视频教程录制并提供容易出现问题的解决方案\"\t\"1.月报系统变更功能，表格导入改为同数据下更新\n" +
                "2.沟通关于玉衡移动端发布资讯功能优化方案、协助发布相关内容\"\t\t\t\"1.日程会议项目数据库脚本整理\n" +
                "2.本地测试调整优化全部接口\n" +
                "\"\t\"1.玉衡平台网络架构图绘制\n" +
                "2.技术文档编写\"\t\"1.玉衡boot版本视频修改调整\n" +
                "2.信息资产一网速查、信息系统一屏管控内容调整、部分功能沟通确认\"\t\"1.日程会议项目发布测试环境并数据接口文档\n" +
                "2.根据前端要求修改功能接口字段\n" +
                "3.月报系统接口字段调整\"\t1.日程会议项目跟前端对接接口，并修改部分字段以及接口逻辑\t\t\t\"1.项目月报系统：根据月度汇报信息中的风险值 更改 项目信息中的风险值\n" +
                "2.项目管理系统独立登录功能封禁，新增统一提示页面\"\t\"1:处理项目管理系统因账号重复导致玉衡平台单点登录异常，数据库紧急处理\n" +
                "2:处理偶发性数据重复导致的项目异常\n" +
                "3.日程会议项目根据前端要求调整接口数据\"\t1:协助igtos董分生产环境升级\t\"1:项目管理系统偶发性bug解决\n" +
                "2:玉衡平台项目支持\"\t\"1:项目月报系统数据库数据清洗整理\n" +
                "2:玉衡平台外包人员管理功能测试\"\t\t\t\"1:项目管理系统删除逻辑同步主表状态修改\n" +
                "2:开发接口检查线下表格内容是否与项目管理内容相符\n" +
                "3:项目管理平台账号异常支持\"\t1:项目管理系统关闭原独立登录页面后导致部分用户(原账号与玉衡不匹配)无法正常使用的问题解决\t\"1:移动端app在玉衡平台移动端发布流程,申请外网访问网关配置\n" +
                "2:项目管理平台技术支持\"\t\"1:移动端网关配合前端做配置调整\n" +
                "2:玉衡平台技术支持\"\t\"1:新增项目管理系统根据年月份自动更新至主表颜色状态的接口\n" +
                "2:排查数据库数据与页面展示数据不一致的问题\n" +
                "3:修改主表更新接口\"\t\t\t\"1:项目月报系统正式数据导入测试环境调整\n" +
                "2:根据最新的表格内容补充数据，但不兼容原数据格式，需开发接口补充数据\"\t\"1:轮驳PMS综合管控平台技术框架单点登录、日志等支持\n" +
                "2:新增项目月报数据同步接口、并修改之前接口完整整个逻辑\"\t\"1:项目月报项目完成接口开发、测试并发布测试至测试环境\n" +
                "2:手动清洗之前非逻辑产生的数据，并同步至生产环境\"\t\"1.协助解决igtos应用异常问题\n" +
                "2.玉衡框架单点登录异常问题协助排拆原因\n" +
                "3.沟通玉衡移动端个别用户报错问题\"\t\"1:项目月报系统数据调整\n" +
                "2:玉衡app用户登录之后报错问题协助排查解决\n" +
                "3:玉衡平台日常技术支持\n" +
                "\"\t\t\t\"1.玉衡我的薪酬访问白屏问题协助排查解决\n" +
                "2.玉衡app登录失败问题排查解决\n" +
                "3.玉衡平台相关人员权限添加及功能使用讲解\n" +
                "4.玉衡pc端登录之后退出再次访问出现白屏现象问题排查\"\t\"1:玉衡移动端网关系统概要设计、详细设计文档编写\n" +
                "2:玉衡平台技术支持\"\t\"1.协助解决新质办工项目玉衡对接问题支持，待办跳转详情审批功能支持\n" +
                "2.框架短信发送功能使用统计\"\t\"1.新质办工项目玉衡对接问题支持，待办跳转详情审批功能支持\n" +
                "2.玉衡应用对接整合进度跟进\n" +
                "3.框架短信发送功能使用统计\"\t\"1.新质办公项目外网反向代理配置并配合前端做调试修改\n" +
                "2.玉衡平台日常技术支持\"";
        String replace = str.replace("\n", "")
                .replace("\"", "");
        String[] list = replace.split("\t");
        for (String s : list) {
            if (StringUtils.isNotBlank(s)) {
                System.out.println(s);
            }
        }

    }
}
