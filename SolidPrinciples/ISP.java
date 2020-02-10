import java.io.*;
import java.util.*;

interface IPost{
    public void postMessage();
}
interface IPicturePost {
    public void postPicture();
}
interface IVideoPost {
    public void postVideo();
}
class PicturePost implements IPost,IPicturePost{
    public void postMessage(){
        System.out.println("Message posted");
    }
    public void postPicture(){
        System.out.println("Picture posted");
    }
}
class VideoPost implements IPost,IVideoPost{
    public void postMessage(){
        System.out.println("Message posted");
    }
    public void postVideo(){
        System.out.println("Video posted");
    }
}
public class ISP{
    void main(){
        PicturePost p=new PicturePost();
        VideoPost v=new VideoPost();
        p.postMessage();
        p.postPicture();
        v.postMessage();
        v.postVideo();
    }
}

    
    