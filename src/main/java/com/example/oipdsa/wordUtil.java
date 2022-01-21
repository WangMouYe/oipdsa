//package com.example.oipdsa;
//import net.sf.json.JSONObject;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.entity.mime.content.StringBody;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.net.plat4j.common.utils.AppConfig;
//import org.net.plat4j.common.utils.FileUtil;
//import org.net.plat4j.common.utils.TemplateFileUtil;
//import org.net.plat4j.common.wordUtil.ResponseModel;
//import org.net.plat4j.sr.core.utils.LogHelper;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.List;
//import java.util.Map;
//
//public class wordUtil {
//    private static LogHelper a = new LogHelper(WordUtils.class);
//    private static HttpClient b = new DefaultHttpClient();
//
//    public static ResponseModel postFileRequest(String arg, File arg0, Map<String, List> arg1) throws Exception {
//        ResponseModel arg2 = new ResponseModel();
//        String arg3;
//        if (StringUtils.isEmpty(arg3 = AppConfig.getString("exportWordServerUrl"))) {
//            throw new RuntimeException("读取配置项 exportWordServerUrl 错误，请联系管理员");
//        } else {
//            HttpPost arg6 = new HttpPost(StringUtils.isEmpty(arg) ? arg3 : arg);
//            String arg12 = JSONObject.fromObject(arg1).toString().replaceAll("\"key\":", "\"Key\":")
//                    .replaceAll("\"value\":", "\"Value\":");
//            a.info("转码前：" + arg12);
//            arg12 = URLEncoder.encode(arg12, "UTF-8");
//            StringBody arg14 = new StringBody(arg12, ContentType.MULTIPART_FORM_DATA);
//            FileBody arg9 = new FileBody(arg0, ContentType.DEFAULT_BINARY);
//            MultipartEntityBuilder arg4;
//            (arg4 = MultipartEntityBuilder.create()).setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//            arg4.addPart("fileName", arg9);
//            arg4.addPart("varValue", arg14);
//            a.info("发送请求的Json参数值为：" + arg12);
//            HttpEntity arg10 = arg4.build();
//            arg6.setEntity(arg10);
//            HttpResponse arg7;
//            int arg11 = (arg7 = b.execute(arg6)).getStatusLine().getStatusCode();
//
//            try {
//                BufferedReader arg8 = new BufferedReader(new InputStreamReader(arg7.getEntity().getContent(), "utf-8"));
//                StringBuffer arg13 = new StringBuffer();
//
//                while ((arg3 = arg8.readLine()) != null) {
//                    arg13.append(arg3);
//                }
//
//                arg8.close();
//                a.info(">>>>>>>请求状态：" + arg11 + "返回的结果内容为：" + arg13);
//                arg2.setStatus(arg11);
//                arg2.setResponseContent(arg13.toString());
//                return arg2;
//            } catch (Exception arg5) {
//                arg2.setStatus(arg11);
//                arg2.setResponseContent("文件生成失败，请联系管理员！");
//                throw new RuntimeException("error", arg5);
//            }
//        }
//    }
//
//    public static String getWordFileIdByTempleteFileId(Long arg, String arg0, Map<String, List> arg1, String arg2,
//                                                       String arg3) {
//        String arg6;
//        try {
//            File arg4 = FileUtil.getFileById(arg0);
//            ResponseModel arg7 = postFileRequest((String) null, arg4, arg1);
//            URL arg8 = new URL(arg7.getResponseContent());
//            File arg9;
//            if (!(arg9 = new File(AppConfig.getString("FreeMarker_Tpl_Dir") + "/" + arg2 + ".doc")).getParentFile()
//                    .exists()) {
//                arg9.getParentFile().mkdirs();
//            }
//
//            FileUtils.copyURLToFile(arg8, arg9);
//            arg6 = FileUtil.uploadForeverFile(arg, arg9, arg3).getId();
//        } catch (Exception arg5) {
//            arg6 = arg0;
//            a.error(arg5);
//        }
//
//        return arg6;
//    }
//
//    public static String getWordFileIdByTempleteFileUrl(Long arg, HttpServletRequest arg0, String arg1,
//                                                        Map<String, List> arg2, String arg3, String arg4) throws Exception {
//        File arg5 = TemplateFileUtil.getTemplateFile(arg, arg0, arg1);
//        ResponseModel arg6 = postFileRequest((String) null, arg5, arg2);
//        URL arg7 = new URL(arg6.getResponseContent());
//        File arg8;
//        if (!(arg8 = new File(AppConfig.getString("FreeMarker_Tpl_Dir") + "/newWordFile" + "/" + arg3 + ".doc"))
//                .getParentFile().exists()) {
//            arg8.getParentFile().mkdirs();
//        }
//
//        FileUtils.copyURLToFile(arg7, arg8);
//        return FileUtil.uploadForeverFile(arg, arg8, arg4).getId();
//    }
//}
