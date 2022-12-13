import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class WebScrapper {
    
    private ArrayList<Address> addressList;
    private ArrayList<Address> processedList = new ArrayList<Address>();
    private int maxDepth;
    private int depth = 0;
    private int normalizationFlag = 0;



    public static void main(String args[]) {
        WebScrapper scrapper;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input:<Depth> <URL>");
        try {
            int maxDepth = 1;//scan.nextInt();
            Address adr = new Address(0,"http://www.google.com/");//scan.next());
            int maxT = 3;//scan.nextInt();
            URLpool pool = new URLpool(adr);
            for ( int i = 0; i < maxT; i++ ) {
                Scrapper runner = new Scrapper(pool, maxDepth, i);
                Thread childTread = new Thread(runner);
                childTread.start();
            }
            


        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
    }


    public WebScrapper(Address adr, int maxDepth) {
        this.addressList = new ArrayList<Address>();
        this.addressList.add(adr);
        this.maxDepth = maxDepth;
    }

    
}
