import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;


public class URLpool {
    private ConcurrentLinkedQueue<Address> addressList;
    private ArrayList<Address> processedList = new ArrayList<Address>();
    public int endflag = 0;

    public int size() {
        return addressList.size();
    }

    public URLpool( Address adr) {
        this.addressList = new ConcurrentLinkedQueue<Address>();
        this.addressList.add(adr);
    }

    public Address getAddress() {
        Address response  = addressList.poll();
        processedList.add(response);
        return response;
    }

    public void addAddress(Address adr) {
        this.addressList.add(adr);
    }
}
