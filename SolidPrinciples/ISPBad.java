import java.io.*;
import java.util.*;

interface iBadPost{
    public void postMessage();
    public void postVideo();
    public void postPicture();
}
class BadPicturePost implements iBadPost{
    public void postMessage(){
        System.out.println("Message posted");
    }
    public void postPicture(){
        System.out.println("Picture posted");
    }
    public void postVideo(){
        System.out.println("No video.I am forced to implement this method");
    }
}
class BadVideoPost implements iBadPost{
    public void postMessage(){
        System.out.println("Message posted");
    }
    public void postPicture(){
        System.out.println("No picture.I am forced to implement this method.");
    }
    public void postVideo(){
        System.out.println("Video posted");
    }
}
public class ISPBad{
    void main(){
        BadPicturePost p=new BadPicturePost();
        BadVideoPost v=new BadVideoPost();
        p.postMessage();
        p.postPicture();
        p.postVideo();
        v.postMessage();
        v.postPicture();
        v.postVideo();
    }
}