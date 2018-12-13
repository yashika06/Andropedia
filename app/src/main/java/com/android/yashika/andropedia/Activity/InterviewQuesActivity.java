package com.android.yashika.andropedia.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.yashika.andropedia.Adapter.InterviewListAdapter;
import com.android.yashika.andropedia.Model.Interview_ques;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

public class InterviewQuesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    InterviewListAdapter adapter;
    ArrayList<Interview_ques> datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_ques);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Interview Questions");
        prepareInterviewList();
        recyclerView = (RecyclerView) findViewById(R.id.inteview_recyclerview);
        adapter = new InterviewListAdapter(InterviewQuesActivity.this,R.layout.list_item_interview,datalist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(InterviewQuesActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void prepareInterviewList() {
        datalist = new ArrayList<>();

        Interview_ques que1 = new Interview_ques("What is android?","Android is a stack of software for mobile devices which has Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine. Many Virtual Machines run efficiently by a DVM device. DVM executes Java language byte code which later transforms into .dex format files.");
        Interview_ques que2 = new Interview_ques("What are the advantages of Android?","The following are the advantages of Android:\n"+
                "   * The customer will be benefited from wide range of mobile applications to choose, since the monopoly of wireless carriers like AT&T and Orange will be broken by Google Android.\n"+
                "   * Features like weather details, live RSS feeds, opening screen, icon on the opening screen can be customized.\n"+
                "   * Innovative products like the location-aware services, location of a nearby convenience store etc., are some of the additive facilities in Android. Components can be reused and replaced by the application framework.\n"
                +"   * Optimized DVM for mobile devices.\n"
                +"   * SQLite enables to store the data in a structured manner.\n"
                +"   * Supports GSM telephone and Bluetooth, WiFi, 3G and EDGE technologies");
        Interview_ques que3 = new Interview_ques("Describe the APK format.","The APK file is compressed the AndroidManifest.xml file, application code (.dex files), resource files, and other files. A project is compiled into a single .apk file.");
        Interview_ques que4 = new Interview_ques("What is .apk extension?","The extension for an Android package file, which typically contains all of the files related to a single Android application. The file itself is a compressed collection of an AndroidManifest.xml file, application code (.dex files), resource files, and other files. A project is compiled into a single .apk file.");
        Interview_ques que5 = new Interview_ques("What is .dex extension?","Android programs are compiled into .dex (Dalvik Executable) files, which are in turn zipped into a single .apk file on the device. .dex files can be created by automatically translating compiled applications written in the Java programming language.");
        Interview_ques que6 = new Interview_ques("What is an activity?","A single screen in an application, with supporting Java code. An activity presents a visual user interface for one focused endeavor the user can undertake. For example, an activity might present a list of menu items users can choose from or it might display photographs along with their captions.");
        Interview_ques que7 = new Interview_ques("What is a service?","A service doesn’t have a visual user interface, but rather runs in the background for an indefinite period of time. For example, a service might play background music as the user attends to other matters, or it might fetch data over the network or calculate something and provide the result to activities that need it.Each service extends the Service base class.");
        Interview_ques que8 = new Interview_ques("How to Remove Desktop icons and Widgets?","Press and Hold the icon or widget. The phone will vibrate and on the bottom of the phone you will see anoption to remove. While still holding the icon or widget drag it to the remove button. Once remove turns red drop the item and it is gone.");
        Interview_ques que9 = new Interview_ques("Describe Android Application Architecture?","Android Application Architecture has the following components:\n"
                +"  * Services\n"
                +"  * Intent \n "
                +" * Resource Externalization \n"
                +"  * Notification signaling users");
        Interview_ques que10 = new Interview_ques("Android application can only be programmed in Java?","False. You can program Android apps in C/C++ using NDK.");
        Interview_ques que11 = new Interview_ques("What are Dalvik Executable files?","Dalvik Executable files have .dex extension and are zipped into a single .apk file on the device.");
        Interview_ques que12 = new Interview_ques("How does Android system track the applications?","Android system assigns each application a unique ID that is called Linux user ID. This ID is used to track each application.");
        Interview_ques que13 = new Interview_ques("What is an Intent?","class (Intent) which describes what a caller desires to do. The caller will send this intent to Android's intent resolver, which finds the most suitable activity for the intent. E.g. opening a PDF document is an intent, and the Adobe Reader apps will be the perfect activity for that intent (class).");
        Interview_ques que14 = new Interview_ques("What is a Sticky Intent?","Sticky Intent is also a type of Intent which allows a communication between a function and a service sendStickyBroadcast() performs a sendBroadcast(Intent) known as sticky, i.e. the Intent you are sending stays around after the broadcast is complete, so that others can quickly retrieve that data through the return value of registerReceiver(BroadcastReceiver, IntentFilter). In all other ways, this behaves the same as sendBroadcast(Intent).");
        Interview_ques que15 = new Interview_ques("What is a resource?","User defined JSON, XML, bitmap, or other file, injected into the application build process, which can later be loaded from code.");
        Interview_ques que16 = new Interview_ques("How to Translate in Android?","The Google translator translates the data of one language into another language by using XMPP to transmit data. You can type the message in English and select the language which is understood by the citizens of the country in order to reach the message to the citizens.");
        Interview_ques que17 = new Interview_ques("What dialog boxes are supported in Android?","Android supports 4 dialog boxes:\n"
                +"  * AlertDialog\n"
                +"  * ProgressDialog\n"
                +"  * DatePickerDialog \n "
                +" * TimePickerDialog");
        Interview_ques que18 = new Interview_ques("What is a Content Provider ?","A class built on ContentProvider that handles content query strings of a specific format to return data in a specific format. See Reading and writing data to a content provider for information on using content providers.");
        Interview_ques que19 = new Interview_ques("What is a Dalvik ?","The name of Android’s virtual machine. The Dalvik VM is an interpreter-only virtual machine that executes files in the Dalvik Executable (.dex) format, a format that is optimized for efficient storage and memory-mappable execution. The virtual machine is register-based, and it can run classes compiled by a Java language compiler that have been transformed into its native format using the included “dx” tool.");
        Interview_ques que20 = new Interview_ques("What is an DDMS ?","Dalvik Debug Monitor Service, a GUI debugging application shipped with the SDK. It provides screen capture, log dump, and process examination capabilities.");
        Interview_ques que21 = new Interview_ques("What is Drawable?","A compiled visual resource that can be used as a background, title, or other part of the screen. It is compiled into an android.graphics.drawable subclass.");
        Interview_ques que22 = new Interview_ques("What are fragments in Android Activity ?","Fragment represents a behavior or a portion of user interface in an Activity. And it is a self-contained component with its own UI and lifecycle.");
        Interview_ques que23 = new Interview_ques("What is BroadReceivers?","BroadcastReceiver is a component that does nothing but receive and react to broadcast announcements. For example, the battery is low or that the user changed a language preference.");
        Interview_ques que24 = new Interview_ques("How many ways data stored in Android?","1.SharedPreferences\n" +
                "2.Internal Storage\n" +
                "3.External Storage\n" +
                "4.SQLite Database\n" +
                "5.Network connection");
        Interview_ques que25 = new Interview_ques("What is View in Android?","Views are the base class for all visual interface elements(commonly known as controls or widgets). All UI controls,including the layout classes,are derived for View.");




        datalist.add(que1);
        datalist.add(que2);
        datalist.add(que3);
        datalist.add(que4);
        datalist.add(que5);
        datalist.add(que6);
        datalist.add(que7);
        datalist.add(que8);
        datalist.add(que9);
        datalist.add(que10);
        datalist.add(que11);
        datalist.add(que12);
        datalist.add(que13);
        datalist.add(que14);
        datalist.add(que15);
        datalist.add(que16);
        datalist.add(que17);
        datalist.add(que18);
        datalist.add(que19);
        datalist.add(que20);
        datalist.add(que21);
        datalist.add(que22);
        datalist.add(que23);
        datalist.add(que24);
        datalist.add(que25);
    }
}
