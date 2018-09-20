package com.yumingchuan.testdemo.pattern;

import com.yumingchuan.testdemo.utils.LogUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yumingchuan on 2018/9/20.
 */

public class PatternTest {
    public void test() {

        //1.Pattern.split(CharSequence input)
        Pattern p = Pattern.compile("\\d+");
        String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");

        for (int i = 0; i < str.length; i++) {
            LogUtils.i(str[i]);
        }

        //2.Pattern.matcher(String regex,CharSequence input)是一个静态方法,用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.
        LogUtils.i("" + Pattern.matches("\\d+", "2223"));//返回true
        LogUtils.i("" + Pattern.matches("\\d+", "2223aa"));//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
        LogUtils.i("" + Pattern.matches("\\d+", "22bb23"));//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到

        //4.Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()
        Pattern p4 = Pattern.compile("\\d+");
        Matcher m = p4.matcher("22bb23");
        LogUtils.i("22bb23 is:" + m.matches());//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
        Matcher m2 = p4.matcher("2223");
        LogUtils.i("2223 is:" + m2.matches());//返回true,因为\d+匹配到了整个字符串

    }
}
