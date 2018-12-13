package com.android.yashika.andropedia.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.android.yashika.andropedia.Adapter.TutorialFragmentAdapter;
import com.android.yashika.andropedia.Model.SubTutorial;
import com.android.yashika.andropedia.Model.Tutorials;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

public class TutorialsFragment extends Fragment {

    RecyclerView recyclerView;
    TutorialFragmentAdapter adapter;
    ArrayList<Tutorials> items;

    public TutorialsFragment() {
        // Required empty public constructor
    }

    public static TutorialsFragment newInstance(){
        return new TutorialsFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorials, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.tutorial_recycler_view);
        recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        prepareList();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TutorialFragmentAdapter(getActivity(),R.layout.list_item_tutorial,items,getFragmentManager());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void prepareList() {
        items = new ArrayList<>();

        ArrayList<SubTutorial> basic = new ArrayList<>();
        basic.add(new SubTutorial("What is Android?","Basics/what_is_android.html"));
        basic.add(new SubTutorial("Android Architecture","Basics/android_architecture.html"));
        basic.add(new SubTutorial("Android History","Basics/android_history.html"));
        basic.add(new SubTutorial("API & Version","Basics/android_versions.html"));
        basic.add(new SubTutorial("Android Application","Basics/android_app.html"));
        basic.add(new SubTutorial("Software Installation","Basics/installing_software.html"));
        basic.add(new SubTutorial("Hello World","Basics/Hello_world.html"));
        basic.add(new SubTutorial("Creating AVD","Basics/creating_avd.html"));
        basic.add(new SubTutorial("Project Structure","Basics/project_structure.html"));
        basic.add(new SubTutorial("AndroidManifest.xml","Basics/android_manifest.html"));
        items.add(new Tutorials("Basic",basic));

        ArrayList<SubTutorial> resources = new ArrayList<>();
        resources.add(new SubTutorial("Resource Files","Resources/resource_files.html"));
        resources.add(new SubTutorial("R.java file","Resources/R_java.html"));
        resources.add(new SubTutorial("Layouts","Resources/layouts.html"));
        items.add(new Tutorials("Resources",resources));

        ArrayList<SubTutorial> uiwidgets = new ArrayList<>();
        uiwidgets.add(new SubTutorial("Introduction","UI/Introduction.html"));
        uiwidgets.add(new SubTutorial("Button","UI/Buttons.html"));
        uiwidgets.add(new SubTutorial("TextView","UI/text_view.html"));
        uiwidgets.add(new SubTutorial("ImageView","UI/image_view.html"));
        uiwidgets.add(new SubTutorial("Radio Button","UI/radio_button.html"));
        uiwidgets.add(new SubTutorial("Checkbox","UI/check_box.html"));
        uiwidgets.add(new SubTutorial("Toast","UI/toast.html"));
        uiwidgets.add(new SubTutorial("Spinner","UI/spinner.html"));
        uiwidgets.add(new SubTutorial("Pickers","UI/pickers.html"));
        uiwidgets.add(new SubTutorial("Alert Dialog","UI/alert_dialog.html"));
        uiwidgets.add(new SubTutorial("Progress Bar","UI/progress_bar.html"));
        items.add(new Tutorials("UI Widget",uiwidgets));

        ArrayList<SubTutorial> activityintent = new ArrayList<>();
        activityintent.add(new SubTutorial("What is Activity?","Activity&Intent/activity.html"));
        activityintent.add(new SubTutorial("Activity Lifecycle","Activity&Intent/activity_lifecycle.html"));
        activityintent.add(new SubTutorial("Intents","Activity&Intent/intents.html"));
        activityintent.add(new SubTutorial("Intent Filter","Activity&Intent/intent_filter.html"));
        activityintent.add(new SubTutorial("Implicit Intent","Activity&Intent/implicit_intent.html"));
        activityintent.add(new SubTutorial("Explicit Intent","Activity&Intent/explicit_intent.html"));
        items.add(new Tutorials("Activity & Intent",activityintent));

        ArrayList<SubTutorial> menu = new ArrayList<>();
        menu.add(new SubTutorial("Option Menu","Menu/option_menu.html"));
        menu.add(new SubTutorial("Context Menu","Menu/context_menu.html"));
        menu.add(new SubTutorial("Popup Menu","Menu/popup_menu.html"));
        items.add(new Tutorials("Menus",menu));

        ArrayList<SubTutorial> containers = new ArrayList<>();
        containers.add(new SubTutorial("ScrollView","Containers/scroll_view.html"));
        containers.add(new SubTutorial("ListView","Containers/list_view.html"));
        containers.add(new SubTutorial("Custom ListView","Containers/custom_list_view.html"));
        containers.add(new SubTutorial("GridView","Containers/grid_view.html"));
        containers.add(new SubTutorial("RecyclerView","Containers/recycler_view.html"));
        containers.add(new SubTutorial("WebView","Containers/web_view.html"));
        containers.add(new SubTutorial("SearchView","Containers/search_view.html"));
        items.add(new Tutorials("Containers", containers));

        ArrayList<SubTutorial> fragments = new ArrayList<>();
        fragments.add(new SubTutorial("Introduction","Fragments/Introduction.html"));
        fragments.add(new SubTutorial("Fragment Lifecycle","Fragments/fragment_lifecycle.html"));
        fragments.add(new SubTutorial("Hosting a Fragment","Fragments/hosting_fragment.html"));
        fragments.add(new SubTutorial("Fragment using Java","Fragments/java_fragment.html"));
        fragments.add(new SubTutorial("Fragment using XML","Fragments/xml_fragment.html"));
        items.add(new Tutorials("Fragments",fragments));

        ArrayList<SubTutorial> services = new ArrayList<>();
        services.add(new SubTutorial("Introduction","Service/intro.html"));
        services.add(new SubTutorial("Service Lifecycle","Service/service_lifecycle.html"));
        services.add(new SubTutorial("Started Service","Service/started_service.html"));
        services.add(new SubTutorial("Bound Service","Service/bound_service.html"));
        items.add(new Tutorials("Services",services));

        ArrayList<SubTutorial> datastorage = new ArrayList<>();
        datastorage.add(new SubTutorial("Introduction","DataStorage/intro.html"));
        datastorage.add(new SubTutorial("Shared Preferences","DataStorage/shared_pref.html"));
        datastorage.add(new SubTutorial("Internal Storage","DataStorage/internal_storage.html"));
        datastorage.add(new SubTutorial("External Storage","DataStorage/external_storage.html"));
        datastorage.add(new SubTutorial("SQLite Database","DataStorage/sqlite.html"));
        items.add(new Tutorials("Data Storage",datastorage));

        ArrayList<SubTutorial> broadcast = new ArrayList<>();
        broadcast.add(new SubTutorial("Introduction","Broadcast/intro.html"));
        broadcast.add(new SubTutorial("System Broadcast","Broadcast/system_broadcast.html"));
        broadcast.add(new SubTutorial("Broadcast Example","Broadcast/example.html"));
        items.add(new Tutorials("Broadcast Receivers",broadcast));

        ArrayList<SubTutorial> providers = new ArrayList<>();
        providers.add(new SubTutorial("Introduction","Providers/intro.html"));
        providers.add(new SubTutorial("Accessing a provider","Providers/accessing.html"));
        providers.add(new SubTutorial("Content Provider Example","Providers/example.html"));
        items.add(new Tutorials("Content Provider",providers));

        ArrayList<SubTutorial> animation = new ArrayList<>();
        animation.add(new SubTutorial("Android Animations","Animations/intro.html"));
        animation.add(new SubTutorial("FadeIn","Animations/fadein.html"));
        animation.add(new SubTutorial("FadeOut","Animations/fadeout.html"));
        animation.add(new SubTutorial("Blink","Animations/blink.html"));
        animation.add(new SubTutorial("ZoomIn","Animations/zoom_in.html"));
        animation.add(new SubTutorial("ZoomOut","Animations/zoom_out.html"));
        animation.add(new SubTutorial("Move","Animations/move.html"));
        animation.add(new SubTutorial("Rotate","Animations/rotate.html"));
        animation.add(new SubTutorial("Bounce","Animations/bounce.html"));
        animation.add(new SubTutorial("SlideUp","Animations/slide_up.html"));
        animation.add(new SubTutorial("SlideDown","Animations/slide_down.html"));
        animation.add(new SubTutorial("Sequential","Animations/sequential.html"));
        animation.add(new SubTutorial("Animation Implementation","Animations/example.html"));
        items.add(new Tutorials("Animations",animation));


        ArrayList<SubTutorial> notification = new ArrayList<>();
        notification.add(new SubTutorial("Android Notification","Notification/intro.html"));
        notification.add(new SubTutorial("Pending Intent","Notification/pending_intent.html"));
        notification.add(new SubTutorial("Notification Example","Notification/example.html"));
        items.add(new Tutorials("Notifications",notification));

        ArrayList<SubTutorial> telephony = new ArrayList<>();
        telephony.add(new SubTutorial("Phone Call","Telephony/phone_call.html"));
        telephony.add(new SubTutorial("Phone Dial","Telephony/phone_dial.html"));
        telephony.add(new SubTutorial("Phone Details","Telephony/phone_details.html"));
        telephony.add(new SubTutorial("Read Contacts","Telephony/read_contacts.html"));

        items.add(new Tutorials("Telephony",telephony));

        /*



        ArrayList<SubTutorial> multimedia = new ArrayList<>();
        multimedia.add(new SubTutorial("MediaPlayer"));
        multimedia.add(new SubTutorial("VideoPlayer"));
        multimedia.add(new SubTutorial("Media Recorder"));
        items.add(new Tutorials("Multimedia",multimedia));
        ArrayList<SubTutorial> web_service = new ArrayList<>();
        web_service.add(new SubTutorial("Web View"));
        web_service.add(new SubTutorial("JSON"));
        web_service.add(new SubTutorial("Async Task"));
        items.add(new Tutorials("Web Services",web_service));

        ArrayList<SubTutorial> design_support = new ArrayList<>();
        design_support.add(new SubTutorial("FAB"));
        design_support.add(new SubTutorial("Snackbar"));
        design_support.add(new SubTutorial("Edit Text"));
        design_support.add(new SubTutorial("Tab Layout"));
        design_support.add(new SubTutorial("Coordinator Layout"));
        design_support.add(new SubTutorial("Collapsing Toolbar"));
        items.add(new Tutorials("Design Support",design_support));

        ArrayList<SubTutorial> material_design = new ArrayList<>();
        material_design.add(new SubTutorial("Introduction"));
        material_design.add(new SubTutorial("Principles"));
        material_design.add(new SubTutorial("Button"));
        material_design.add(new SubTutorial("Cards"));
        material_design.add(new SubTutorial("Chips"));
        material_design.add(new SubTutorial("Data Table"));
        material_design.add(new SubTutorial("Dialogs"));
        material_design.add(new SubTutorial("Dividers"));
        material_design.add(new SubTutorial("GridList"));
        material_design.add(new SubTutorial("List"));
        material_design.add(new SubTutorial("Menu"));
        material_design.add(new SubTutorial("Picker"));
        material_design.add(new SubTutorial("Progress Activity"));
        material_design.add(new SubTutorial("Selection Controls"));
        material_design.add(new SubTutorial("Sliders"));
        material_design.add(new SubTutorial("Snackbar & Toast"));
        material_design.add(new SubTutorial("SubHeaders"));
        material_design.add(new SubTutorial("Steppers"));
        material_design.add(new SubTutorial("Tabs"));
        material_design.add(new SubTutorial("TextField"));
        material_design.add(new SubTutorial("Toolbar"));
        material_design.add(new SubTutorial("Tooltips"));
        items.add(new Tutorials("Material Design",material_design));

        ArrayList<SubTutorial> misc = new ArrayList<>();
        misc.add(new SubTutorial("Camera API"));
        misc.add(new SubTutorial("Clipboard Manager"));
        items.add(new Tutorials("Miscellaneous",misc));*/


    }


}
