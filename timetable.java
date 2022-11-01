import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import  java.util.*;
import java.io.IOException;
import pp.packah;

import static java.lang.Math.abs;

interface  dateTime
{

    static Date dNow = new Date( );
    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

}
abstract interface  Fight
{
     String BestCase();
}

public class timetable implements dateTime , Fight {

    timetable(String s)
    {
        System.out.println("hello "+ s + "\n" + "Have a nice day! :>) ");
        System.out.println("!--------------------------------!");
    }
    timetable()
    { }

    static void Gmssg()
    {
        System.out.println("your attendence is recorded");
        System.out.println("--- Hope You ENJOYED The Service!---");
    }


    public static void main(String[] args) throws IOException {

        timetable adii=new timetable();
        String start=adii.BestCase();// start time //
        System.out.println("\n");
        System.out.println(" You Started At: "+start);
        System.out.println("!--------------------------------!");

        System.out.println("Can You Please Type Your Name, Sir/Ma'am ? ");
        Scanner sir=new Scanner(System.in);
        String  name=sir.nextLine();
        timetable obbj=new timetable(name);
        System.out.println("Today Date and Time of Attendence is : ");
        System.out.println("!--------------------------------!");
        timetable objj=new timetable();
        System.out.println(objj.ft.format(dNow));
        System.out.println();
        System.out.println("To Get Student Data Press 1  , Else Press Any Other Numeric Key ");
        Scanner sci = new Scanner(System.in);
        int g = sci.nextInt();
        if (g == 1) {
            packah obj = new packah();
            obj.getcount();
            obj.getdata();
        }

        System.out.println("Create a Text File , To Store The Attendence!!");
        System.out.println("[ give it a name: ( with .txt as extension ) ]");
        String s;
        Scanner input=new Scanner(System.in);
        s=input.nextLine();

        System.out.println("Press 1 to Create File");
        int i;
        Scanner in=new Scanner(System.in);
        i=in.nextInt();
        if(i==1)
        {
            File Obj = new File(s);
            int p=1;
            try {
                //File Obj = new File(s);
                if (Obj.createNewFile()) {
                    System.out.println("File created: "
                            + Obj.getName());
                    System.out.println("!--------------------------------!");
                }
                else {
                    p=0;
                    System.out.println("File already exists.");
                    System.out.println("Try Again , With A Different Name");
                }
            }
            catch (IOException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }
            if(p!=0) {

                System.out.println("Take your attendence now : ");
                FileWriter write = new FileWriter(s);
                for (int j = 0; j < 7; j++) {
                    System.out.println("Roll No. : " + (j + 1) + " is : ");
                    char c;
                    Scanner adi = new Scanner(System.in);
                    c = adi.next().charAt(0);
                    write.write("Roll No." + (j + 1) + " is : " + c + "\n");
                }
                write.close();

            }
        }
        else
        {
            System.out.println("Again Run The Program!!");
        }

        String end=adii.BestCase();
        System.out.println("You Ended At :" +end);
        String h1=start.substring(11 , 13);
        String h2=end.substring(11, 13);
        String m1=start.substring(14 , 16);
        String  m2=end.substring(14 , 16);
        String ss1=start.substring(17, 19);
        String ss2=end.substring(17 , 19);
        int hh1=abs(Integer.parseInt(h2)-Integer.parseInt(h1));
        int mm2=abs(Integer.parseInt(m2)-Integer.parseInt(m1));
        int ss22=abs(Integer.parseInt(ss2)-Integer.parseInt(ss1));
        System.out.println("Total Time Taken By You Is:" + (ss22 + ( mm2*60) + ( hh1*60*60))+ " seconds");
        System.out.println("!--------------------------------!");
        Gmssg();// static mssg, as it doesn't depend over the input, it will always be printed//

    }

    @Override
    public String BestCase() {

        LocalDateTime myObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return myObj.format(myFormatObj).toString();

    }

}
