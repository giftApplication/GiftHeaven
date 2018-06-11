package com.example.moon.giftheaven.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.models.Gift;
import com.example.moon.giftheaven.views.activities.gift_detail;
import com.example.moon.giftheaven.views.activities.main_activity;

import java.util.ArrayList;

/**
 * Created by moon on 5/2/2018.
 */

public class CustomListView extends BaseAdapter implements View.OnClickListener {


    Context c;
    Gift gift;
    ArrayList<Gift> giftlist = new ArrayList<>();

    ///=========================================================================================================
    public  static String[] gift_names = {"Slippers","Playking Notebook","Trolley","Rope Swing","Dictionary Book Safe","Headphone","Hanging Crystal Votive White","Cushion Cover With Filler","Cocktail Coco Pen Stand","Candle Stand","Velvet Cushion Cover"};

    public static  String[] desc = {"Rs.1499","Rs.652","Rs.1599","Rs.980","Rs.1099","Rs.1499","Rs.1530","Rs.506","Rs.720","Rs.750","Rs.599"};
    // public int index;
    public static String[] description={"TASTYTOASTY FEETLet this pair of zombies gently mouth your feet.When theres no more room in hell the dead will walk the earth and we will make supercomfortable plush slippers out of their heads.","Specifications of Playking English Learner Educational Notebook (Multicolor) Important Note The color of some product parts may vary from what is shown in the image","Specifications of Toys Bhoomi Kids Market Trolley Product DimensionsProduct Weight 800 gGeneralAge Group 1- 6 Years Ideal for Girls Boys Type Roleplay Accessories Series Shopping Trolley Occasion Birthday Childrens Day Casual PlayImportant","100% Cotton Rope thick dia for maximum durability. Hardwood spreader bar.Single person Cotton rope Hammock Swing chair. Weight capacity 249 lb. Swing frame to be purchased separately.","Keep your valuables safeCategoryCreative GiftsKeep your valuables secure with this ingenious book shaped safe Not only does the cleverly disguised Book Safe keep your valuables under lock and key but with its New English Dictionary cover it could easily be mistaken for just another book on your shelf and the last thing that a thief will have time to do when hunting for swag is to go rifling through the dictionary to find the definition of outfoxed","Key Features of Philips SHL3105WT00 Overtheear Headphone (White Overtheear) 40 mm Headphone Driver UnitsOverthehead Design18 Hz\n" +
            " 20000 Hz Headphone Frequency ResponseNeodymium MagnetOvertheear HeadphonesCircumaural Closed Headphones1500 mW of Max Power Input Specifications\n" +
            " of Philips SHL3105WT00 Overtheear Headphone (White Overtheear) General Brand Philips Headphone ","Material crystal Color white Style Contemporary Votive Diameter 4.3 inches (11 cm) Height 6 inches (15 cm) Quantity 1 Piece (Votive)","Material Taffeta Silk Color Black Thread Count 200 Pattern Contemporary Closing Flap Filling Material Polyfill \n" +
            "Cushion Length 16 inches (40 cm) Width 16 inches (40 cm) Quantity 1 Piece (Cushion Cover With Filler)","Material Recycled Wood & MDF Color Dark Brown Pen Stand Height 4.5\n" +
            " inches (11 cm) Length 4.5 inches (11 cm) Width 6.2 inches (16 cm) Quantity 1 Piece (Pen Stand)","Material Wrought Iron Color Black Weight 0.2 kg Style Traditional Candle Stand Diameter 6 inches \n" +
            "(15 cm) Height 3.5 inches (9 cm) Quantity 1 Piece (Candle Stand)","Material Poly Velvet Color Pink Style Contemporary Pattern Contemporary Closing\n" +
            " Zipper Small Cushion Cover Length 12 inches (30 cm) Width 12 inches (30 cm) Medium Cushion Cover Length 16 inches (40 cm)\n" +
            " Width 16 inches (40 cm) Large Cushion Cover Length 18 inches (45 cm) Width 18 inches (45 cm) Extra Large Cushion Cover Length \n" +
            "20 inches (50 cm) Width 20 inches (50 cm) Available In 4 Variations\n" +
            " (Small Cushion Cover Medium Cushion Cover Large Cushion Cover & Extra Large Cushion Cover)"};
    public static Integer[] imgid = {R.drawable.birthday,R.drawable.birthday,R.drawable.birthday,R.drawable.birthday,R.drawable.vase,R.drawable.vase,R.drawable.charlie_red,R.drawable.charlie_red,R.drawable.vase,R.drawable.charlie_red,R.drawable.vase};

    public static String[] events_array={"Birthday","Birthday","Birthday","Birthday","Birthday","Birthday","Birthday","Birthday","Birthday","Birthday","Birthday"};

    public static String[] category_array={"Kids","Kids","Kids","Kids","Male","Male","Female","Female","Male","Female","Male"};

    public static String[] budget_array={"1499","652","1599","980","1099","1499","1530","506","720","750","599"};

    //farah iski array bana laina jo jo gift hai na site pai open kar kai uska url yahan paste karti jao
   public  static String link_array ="https://www.giftsnideas.com";


  //================================================================================================================
    public CustomListView(Context ctx) {
        this.c = ctx;
    }

    public CustomListView(Context c, int index, ArrayList<Gift> giftlist) {
        this.c = c;
       // this.index = index;
        this.giftlist = giftlist;
    }

    @Override
    public int getCount() {
        return  giftlist.size();//gift_names.length;
    }

    @Override
    public Object getItem(int pos) {
        return  giftlist.get(pos);//gift_names[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }


    @Override
    public View getView(int pos, View convertview, ViewGroup viewGroup) {
        View_holer view_holer = new View_holer();
       /// index=pos;
        //get view
        //final int position = listView.getPositionForView(parentRow);
       // System.out.println("pos=" + pos);


        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.layout, null);
            //index= pos;
            view_holer.nametxt=(TextView) convertview.findViewById(R.id.text1);
            view_holer.pricetxt = (TextView) convertview.findViewById(R.id.text_d1);
            view_holer.link = (TextView) convertview.findViewById(R.id.text_link);
            view_holer.img = (ImageView) convertview.findViewById(R.id.img1);
            convertview.setTag(view_holer);

        }
        else
            view_holer=(View_holer) convertview.getTag();


        //set data

        gift = giftlist.get(pos);

        view_holer.pricetxt.setText(gift.getPrice());
        //System.out.println("gift price" + gift.getPrice());
        view_holer.nametxt.setText(gift.getName());
        view_holer.link.setOnClickListener(this);
        view_holer.img.setImageResource(gift.getImage());
        /*view_holer.nametxt.setText(gift_names[pos]);
        view_holer.pricetxt.setText(desc[pos]);
        view_holer.link.setOnClickListener(this);
        view_holer.img.setImageResource(imgid[pos]);*/

        return convertview;
    }



    @Override
    public void onClick(View view) {
        Intent intent = new Intent(c, gift_detail.class);
        final int position = main_activity.lst.getPositionForView(view);
        System.out.println("Position value " + position);
        intent.putExtra("Position", position);
        c.startActivity(intent);
    }
}