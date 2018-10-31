import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class split {
    public static void main(String[] args) {//方法展示
        String str = "acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi";
        String ch = ",";
        my_str s = new my_str(str, ch);
        s.get_all_num(true);       //返回所有纯数字字符串，参数为是否打印
        s.get_all_upper(true);     //返回所有纯大写字符串
        s.get_all_lower(true);     //返回所有纯小写字符串
        s.get_all_abc(true);       //返回所有纯字母字符串
        s.all_to_upper(true);      //将所有纯字母转为大写
        s.all_abc_sort();          //将字母排序，然后输出
        s.all_num_sort();          //将数字排序，然后输出
    }
}

class my_str{
    //
    private String str;
    private String[] temp;
    //
    my_str(String s, String t){
        setStr(s);
        setTemp(this.str.split(t));
    }

    my_str(String[] s){
        setTemp(s);
    }
    //
    public void setStr(String str){
        this.str = str;
    }
    public String getStr(){
        return this.str;
    }
    private void setTemp(String[] s){
        this.temp = s;
    }
    public String[] getTemp(){
        return this.temp;
    }
    //
    public int len(){
        return this.temp.length;
    }

    private boolean is_all_num(String s){
        for (int n = 0; n < s.length(); n++){
            char ch = s.charAt(n);
            if (!Character.isDigit(ch)) return false;
        }
        return true;
    }

    private boolean is_all_lower(String s){
        for (int n = 0; n < s.length(); n++){
            char ch = s.charAt(n);
            if (!Character.isLowerCase(ch)) return false;
        }
        return true;
    }

    private boolean is_all_upper(String s){
        for (int n = 0; n < s.length(); n++){
            char ch = s.charAt(n);
            if (!Character.isUpperCase(ch)) return false;
        }
        return true;
    }

    private boolean is_all_abc(String s){
        for (int n = 0; n < s.length(); n++){
            char ch = s.charAt(n);
            if (!(Character.isUpperCase(ch) || Character.isLowerCase(ch))) return false;
        }
        return true;
    }

    private char[] sort_one(String s){
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return chs;
    }

    public String[] get_all_lower(boolean p){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < this.len(); i++){
            if (this.is_all_lower(this.temp[i])) {
                list.add(this.temp[i]);
                if (p) System.out.println(this.temp[i]);
            }
        }
        return list.toArray(new String[1]);
    }

    public String[] get_all_upper(boolean p){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < this.len(); i++){
            if (this.is_all_upper(this.temp[i])) {
                list.add(this.temp[i]);
                if (p) System.out.println(this.temp[i]);
            }
        }
        return list.toArray(new String[1]);
    }

    public String[] get_all_num(boolean p){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < this.len(); i++){
            if (this.is_all_num(this.temp[i])) {
                list.add(this.temp[i]);
                if (p) System.out.println(this.temp[i]);
            }
        }
        return list.toArray(new String[1]);
    }

    public String[] get_all_abc(boolean p){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < this.len(); i++){
            if (this.is_all_abc(this.temp[i])) {
                list.add(this.temp[i]);
                if (p) System.out.println(this.temp[i]);
            }
        }
        return list.toArray(new String[1]);
    }

    public String[] all_to_upper(boolean p){
        String[] s = this.get_all_abc(false);
        for (int i = 0; i < s.length; i++){
            s[i] = s[i].toUpperCase();
            if (p) System.out.println(s[i]);
        }
        return s;
    }

    public void all_abc_sort(){
        String[] s = this.get_all_abc(false);
        for (int n = 0; n < s.length; n++) System.out.println(this.sort_one(s[n]));
    }

    public void all_num_sort(){
        String[] s = this.get_all_num(false);
        for (int i = 0; i < s.length; i++) System.out.println(this.sort_one(s[i]));
    }

}

