package com.example.knowyourgarden.placeholder;

import com.example.knowyourgarden.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();


    public static String arrname[] = {"Alis", "Naina", "Bob", "Julia", "Marry", "Tony Stark", "Chris", "Tom Holland", "Thor", "Elivis", "Leon", "Captain America",
            "Dr Strange", "Ant Man", "Charles", "Hulk"};

    public static  String arrmessage[] = {"Hi", "Hello", "How are You", "Hello,How are You", "I am fine", "hi,what about you", "your name is thor", "No ",
            "is you are a studen ", "yes i am ", "ok ", "Good night", "Good Morning", "Good AfterNoon", "hello, Sir", "Hi,Maam"};

    public static int arrimage[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a10, R.drawable.a7, R.drawable.a8
            , R.drawable.a9, R.drawable.a6, R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16};


    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
        return new PlaceholderItem(String.valueOf(position),arrimage[position],arrname[position], makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;
        public final int imgd;

        public PlaceholderItem(String id,int imgd,String content, String details) {
            this.id = id;
            this.imgd = imgd;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}