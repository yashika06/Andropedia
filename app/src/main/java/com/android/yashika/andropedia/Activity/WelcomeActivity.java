package com.android.yashika.andropedia.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.yashika.andropedia.Model.Questions;
import com.android.yashika.andropedia.PrefManager;
import com.android.yashika.andropedia.QuestionDBHelper;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;
import java.util.Iterator;

public class WelcomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private WelcomeViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    ArrayList<Questions> questionsArrayList;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);
        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3};

        // adding bottom dots
        addBottomDots(0);
        changeStatusBarColor();

        myViewPagerAdapter = new WelcomeViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });

        insertQuestion();

    }


    private void insertQuestion(){
        QuestionDBHelper dbHelper = new QuestionDBHelper(WelcomeActivity.this);
        prepareQuestionList();
        Iterator iterator = questionsArrayList.iterator();
        while (iterator.hasNext()){
            Questions questions = (Questions) iterator.next();
            dbHelper.insertQuestion(questions);
        }
    }


    private void prepareQuestionList() {
        questionsArrayList = new ArrayList<>();

        Questions qu1 = new Questions("Android is licensed under which open source licensing license?","Gnu’s GPL","Apache/MIT","OSS","Sourceforge","B");
        Questions qu2 = new Questions("Who owns the Android platform?","Oracle Technology","Dalvik","Open Handset Alliance","Google","C");
        Questions qu3= new Questions("What was the first phone released that ran the Android OS?","Google gPhone","T-Mobile G1","Motorola Droid","HTC Hero","B");
        Questions qu4= new Questions("What year was the Open Handset Alliance announced?","2005","2006","2007","2008","C");
        Questions qu5= new Questions("Android tries hard to _________ low-level components, such as the software stack, with interfaces so that vendor-specific code can be managed easily.","confound","absract","modularize","compound","B");
        Questions qu6= new Questions("What part of the Android platform is open source?","low-level Linux modules","native libraries","application frame work","All of the above","D");
        Questions qu7= new Questions("When did Google purchase Android?","2005","2007","2006","2004","A");
        Questions qu8= new Questions("Android releases since 1.5 have been given nicknames derived how?","Adjective and strange animal","Food","American states","None of the above","B");
        Questions qu9= new Questions("Which among these are NOT a part of Android’s native libraries?","Dalvik","Webkit","OpenGL","SQLite","A");
        Questions qu10= new Questions("Android is based on Linux for the following reason?","Security","Portability","Networking"," All of these","D");
        Questions qu11= new Questions("What operating system is used as the base of the Android stack?","Linux","Windows","Java","XML","A");
        Questions qu12= new Questions("Which piece of code used in Android is not open source?","Keypad driver","WiFi driver","Audio driver","Power management","B");
        Questions qu13= new Questions("When developing for the Android OS, Java byte code is compiled into what?","Java source code","Dalvik application code","Dalvik byte code","source code","C");
        Questions qu14= new Questions("What does the .apk extension stand for?","Application Package","Application Program Kit","Android Proprietary Kit","Android Package","A");
        Questions qu15= new Questions("Which of these are not one of the three main components of the APK?","Dalvik Executable","Resources","Native Libraries","Webkit","D");
        Questions qu16= new Questions("What is the name of the program that converts Java byte code into Dalvik byte code?","Android Interpretive Compiler (AIC)","Dalvik Converter","Dex compiler","Mobile Interpretive Compiler (MIC)","C");
        Questions qu17= new Questions("What is contained within the manifest xml file?","The permissions the app requires","The list of strings used in the app","The source code","None of the above","A");
        Questions qu18= new Questions("The Emulator is identical to running a real phone EXCEPT when emulating/simulating what?","Telephony","Applications","Sensors","None of the above","C");
        Questions qu19= new Questions("To create an emulator, you need an AVD. What does it stand for?","Android Virtual Display","Android Virtual Device","Active Virtual Device","Application Virtual Display","B");
        Questions qu20= new Questions("What is the driving force behind an Android application and that ultimately gets converted into a Dalvik executable?","Java source code","R-file","Emulator","SDK","A");
        Questions qu21= new Questions("What are the indirect Direct subclasses of Activity?","launcherActivity","preferenceActivity","tabActivity","All of the above","D");
        Questions qu22= new Questions("Which are the  screen densities in Android?","low density","extra high density","medium density","All of the above","D");
        Questions qu23= new Questions("You can shut down an activity by calling its _______ method"," onDestory()","finish()"," finishActivity()"," none of the above","B");
        Questions qu24= new Questions("If your service is private to your own application and runs in the same process as the client (which is common), you should create your interface by extending the ________class?","messenger","AIDL","binder","None of the above","C");
        Questions qu25= new Questions("Which component is not activated by an Intent?","activity","services","broadcastReceiver","contentProvider","D");
        Questions qu26= new Questions("If you need your interface to work across different processes, you can create an interface for the service with a ________?","Binder","AIDL","Messenger"," b or c","D");
        Questions qu27= new Questions("Which of the  important device characteristics that you should consider as you design and develop your application?","screen size and density","input configurations","device features","all the above","D");
        Questions qu28= new Questions("Parent class of Activity?","ContextThemeWrapper","Context","ActivityGroup","Object","A");
        Questions qu29= new Questions("Parent class of Service?","Object","ContextWrapper","Context","ContextThemeWrapper","B");
        Questions qu30= new Questions("What are the indirect Direct subclasses of Services?","inputMethodService","recognitionService","remoteViewsService","spellCheckerService","A");
        Questions qu31= new Questions("Which one is NOT related to fragment class?","listFragment","dialogFragment","cursorFragment","preferenceFragment","C");
        Questions qu32= new Questions("What are the ways to start services?","Started","Bound","Both of them","None of them","C");
        Questions qu33= new Questions("How contentProvider would be activated?","using ContentResolver","using Intent","using SQLite","none of the above","A");
        Questions qu34= new Questions("What built-in database is Android shipped with?","SQLite","Apache","MySQL","Oracle","A");
        Questions qu35= new Questions("Which of the following is NOT a state in the lifecycle of a service?","Starting","Running","Destroyed","Paused","D");
        Questions qu36= new Questions("When an activity doesn’t exist in memory it is in","Running state","Starting state","Inexistent state","Loading state","B");
        Questions qu37= new Questions("Status data will be exposed to the rest of the Android system via:","Intents","Network receivers","A content provider","Altering permissions","C");
        Questions qu38= new Questions("Creating a UI (User Interface) in Android requires careful use of…","Java and SQL"," XML and Java","XML and C++","Dream weaver","B");
        Questions qu39= new Questions("What file is responsible for glueing everything together, explaining what the application consists of, what its main building blocks are, ext.…?","Layout file","Strings XML","R file"," Manifest file","D");
        Questions qu40= new Questions("Dialog classes in android?","AlertDialog","ProgressDialog","DatePickerDialog","All of the above","D");
        Questions qu41= new Questions("The XML file that contains all the text that your application uses.","stack.xml","text.xml","strings.xml","string.java","C");
        Questions qu42= new Questions("If the UI begins to behave sluggishly or crash while making network calls, this is likely due to…","Network latency","Hardware malfunctions","Virus on the Server","Activity manager contains too much.","A");
        Questions qu43= new Questions("When the activity is not in focus, but still visible on the screen it is in?","Running state","Stopped state"," Paused state","Destroyed state","C");
        Questions qu44= new Questions("Which of the following should be used to save the unsaved data and release resources being used by an Android application?","Activity.onStop()","Activity.onDestroy()","Activity.onPause()"," Activity.onShutdown()","B");
        Questions qu45= new Questions("Which of the following is/are appropriate for saving the state of an Android application?","Activity.onPause()","Activity.onFreeze()","Activity.onDestroy()","Activity.onStop()","A");
        Questions qu46= new Questions("Which of the following can be used to bind data from an SQL database to a ListView in an Android application?","SimpleCursor","SimpleCursorAdapter","SimpleAdapter","SQLiteCursor","B");
        Questions qu47= new Questions("Which of the following function calls can be used to start a Service from your Android application?","bindService()"," startService()","runService()","Both a&b","D");
        Questions qu48= new Questions("Which of the following is the parent class for the main application class in an Android application that has a user interface?","MIDLet","AndroidApp"," Activity","AppLet","C");
        Questions qu49= new Questions("Which of the following would you have to include in your project to use the SimpleAdapter class?"," import android.content","import android.widget"," import android.database","import android.database.sqlite","B");
        Questions qu50= new Questions("Which of the following can you use to display a progress bar in an Android application?"," ProgressBar","ProgressDialog","ProgressView","Both a&b","D");
        Questions qu51= new Questions("Immediate base class for activity and services"," Context","ApplicationContext","ContextApp","OnCreate","A");
        Questions qu52= new Questions("Which of the following are valid features that you can request using requestWindowFeature?","  FEATURE_NO_TITLE","FEATURE_NO_ICON","FEATURE_RIGHT_ICON","Both a&c","D");
        Questions qu53= new Questions("Which of the following can you use to add items to the screen menu?","Activity.onCreateOptionsMenu"," Activity.onPrepareOptionsMenu","Activity.onCreate","Both a&c","D");

        questionsArrayList.add(qu1);
        questionsArrayList.add(qu2);
        questionsArrayList.add(qu3);
        questionsArrayList.add(qu4);
        questionsArrayList.add(qu5);
        questionsArrayList.add(qu6);
        questionsArrayList.add(qu7);
        questionsArrayList.add(qu8);
        questionsArrayList.add(qu9);
        questionsArrayList.add(qu10);
        questionsArrayList.add(qu11);
        questionsArrayList.add(qu12);
        questionsArrayList.add(qu13);
        questionsArrayList.add(qu14);
        questionsArrayList.add(qu15);
        questionsArrayList.add(qu16);
        questionsArrayList.add(qu17);
        questionsArrayList.add(qu18);
        questionsArrayList.add(qu19);
        questionsArrayList.add(qu20);
        questionsArrayList.add(qu21);
        questionsArrayList.add(qu22);
        questionsArrayList.add(qu23);
        questionsArrayList.add(qu24);
        questionsArrayList.add(qu25);
        questionsArrayList.add(qu26);
        questionsArrayList.add(qu27);
        questionsArrayList.add(qu28);
        questionsArrayList.add(qu29);
        questionsArrayList.add(qu30);
        questionsArrayList.add(qu31);
        questionsArrayList.add(qu32);
        questionsArrayList.add(qu33);
        questionsArrayList.add(qu34);
        questionsArrayList.add(qu35);
        questionsArrayList.add(qu36);
        questionsArrayList.add(qu37);
        questionsArrayList.add(qu38);
        questionsArrayList.add(qu39);
        questionsArrayList.add(qu40);
        questionsArrayList.add(qu41);
        questionsArrayList.add(qu42);
        questionsArrayList.add(qu43);
        questionsArrayList.add(qu44);
        questionsArrayList.add(qu45);
        questionsArrayList.add(qu46);
        questionsArrayList.add(qu47);
        questionsArrayList.add(qu48);
        questionsArrayList.add(qu49);
        questionsArrayList.add(qu50);
        questionsArrayList.add(qu51);
        questionsArrayList.add(qu52);
        questionsArrayList.add(qu53);



    }


    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.dot_dark_screen2));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.dot_light_screen2));
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    public class WelcomeViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;


        public WelcomeViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
