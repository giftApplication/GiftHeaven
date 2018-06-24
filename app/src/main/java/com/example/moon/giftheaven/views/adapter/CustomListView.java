package com.example.moon.giftheaven.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.models.Gift;
import com.example.moon.giftheaven.models.GiftsData;
import com.example.moon.giftheaven.models.parse_json;
import com.example.moon.giftheaven.views.activities.gift_detail;
import com.example.moon.giftheaven.views.activities.main_activity;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by moon on 5/2/2018.
 */

public class CustomListView extends BaseAdapter implements View.OnClickListener {


    Context c;
    Gift gift;
    ArrayList<Gift> giftlist = new ArrayList<>();

    ///=========================================================================================================
    public  static String[] gift_names = {"Slippers","Playking Notebook","Trolley","Rope Swing","Dictionary Book Safe","Headphone",
            "Hanging Crystal Votive White","Cushion Cover With Filler","Cocktail Coco Pen Stand","Candle Stand",
            "Velvet Cushion Cover","Rotating Photo","Earring","Suitcase","Smart Watch","Trolley Bag",
            "Bubble Balloon","Windchime","Watch","Cufflinks","Glass With Lid","Watch","Table Lamp","Cufflink","Heart Shaped Glass","Wall Print Sticker","Coffee Maker","Rosette Trunk Set","Antique Lamp"};
    public static  String[] desc = {"Rs.1499","Rs.652","Rs.1599","Rs.980","Rs.1099","Rs.1499",
            "Rs.1530","Rs.506","Rs.720","Rs.750","Rs.599","Rs.2800","Rs.2735","Rs.2150","Rs.2920",
            "Rs.2732","Rs.2599","Rs.999","Rs.805",
            "Rs.1100","Rs.1399","Rs.1432","Rs.1470","Rs.501","Rs.599","Rs.2499","Rs.2149","Rs.2500","Rs.2284"};
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
            " (Small Cushion Cover Medium Cushion Cover Large Cushion Cover & Extra Large Cushion Cover)","17 inch tall rotates lamp\n" +
            "Maximum 16 to 18 pictures can be adjusted with a quote\n" +
            "Lamp rotates with electricity\n" +
            "Email pictures at info@awwsme.com with Order no.\n" +
            "Special collection for valentines day","Specifications of The Art Jewellery Alloy Stud Earring In the Box Sales Package 1 Pair of Earring \n" +
            "General Brand The Art Jewellery Model Number ER10446CL Type Stud Earring PreciousArtificial Jewellery Fashion Jewellery\n" +
            " Color White Ideal For Women Occasion Wedding & Engagement Body & Design Features Base Material Alloy Piercing Required Yes Number of Pairs 1","About the product:Key Features of American Tourister Milan Strolley Suitcase - 21.7 \n" +
            "(Cyan Blue) 2 Compartments2 PocketsSmall SuitcasePolyester and Nylon Body1 Center Lock2 Wheels","Functions Chronograph No Altimeter No Date Display Yes Day and Date Display Barometer No \n" +
            "Alarm Clock Yes Alarm Settings Compass Analog Compass Calendar Yes Luminous No","TBags presents a trolley bag. This bag has a 3D Space Shuttle design in vibrant color. \n" +
            "It has a personalised identification label printed on the bag. Easy to handle with specially designed wheels that can climb staircase when pulled by a kid. ","Baby Boy Bubble Balloon CODE Baby Boy Bubble Balloon","Make your wife remember you fondly, everytime she looks and the soft flowy feathers moving around in the colors!","Sonata Yuva Gold Analog Watch - For Women (Red) Price: Rs.699 Key Features\n" +
            " Contemporary DialRed StrapWater Resistant Sleek, smooth and sophisticated, this wonderfully \n" +
            "designed analog watch from Sonata’s Yuva Gold collection for women comes well equipped to accurately\n" +
            " keep track of time and do so with great style. Presenting a prominent design that is all about expressing \n" +
            "grace and elegance, \n" +
            "this women’s watch is a great gift and definite choice for any of your casual get-togethers.","Refund Specification In the Box One Pair of Cufflinks General Type Cufflinks Series Glossy Enameled Material \n" +
            "Rhodium Plated Pattern Glossy Metal Texture Pattern Style Code LCU0036ENRD Color Code SILVER.","Fill It To The BrimCategory Housewarming GiftsSubCategory Unique GiftsHot coffee or a steaming cup of tea drink them with \n" +
            "contentment in this glass. Made from fine glass double glass with lid contains two layers to provide proper insulation to your hands from the \n" +
            "temperature. These heat resistant cups are a set of 3 with capacity of 250ml 350ml and 450ml each.",
            "Functions Date Display","In The Box Number of Contents in Sales Package Pack of 1 Sales Package Table Lamp","General Type Cufflink " +
            "Set Material Brass Series Tripin43 Style Code TSilver43 Pattern Self Design Pattern Ideal For Men Color Code Silver","Pour out your heartCategory Gifts for WomenSubCategory Unique GiftsA transparent heartshaped \n" +
            "tea or coffee glass for you to drink the hot drinks of your choice Fill it will love and drink with contentment \n" +
            "to its capacity of 240 ml. Its a double layered glass cup to provide maximum insulation from heat and thus are heat\n" +
            " resistant. So sip your teacoffee and fall in love with them all over againHeart ShapedTransparent \n" +
            "glassDouble layeredMaterial GlassHeat Resistant240ML CapacityPackage Includes 1 x Heart Shaped Glass","Digitally " +
            "Printed Unframed Art PrintLamination GlossTotal Size 150x91 Cms (Approx)Self Adhesive Art PrintComes in " +
            "Plastic Tube","Black & Decker Coffee Bean Mill CBM 3 Coffee Maker (White) Price Rs.2320 The Black and Decker CBM3 is a blade type coffee grinder that gives you the freedom of grinding your own freshly ground coffee powder. The bean grinder sports a compact chassis that tapers up from a wide base giving it " +
            "added stability. ","These beautiful looking oval shaped set of three boxes are great for storing little jewellery letters makeup or other valuables at home. With a vintage rose design they can be stacked on top of each other as a pretty" +
            " bedroom display."," Material: Iron Wire\n" +
            " Color: Rust Antique\n" +
            " Recommended Wattage: 40 Watt\n" +
            " Number of Bulbs Required: 1\n" +
            " Holder Type: E27 Holder\n" +
            " Wire Length: 114\n" +
            " Height: 24.8 inches (62 cm)\n" +
            "Length: 10 inches (25 cm)"};
    public static Integer[] imgid = {R.drawable.a_1,R.drawable.b_1,R.drawable.c_1,R.drawable.d_1
            ,R.drawable.e_1,R.drawable.f_1,R.drawable.g_1,R.drawable.h_1,R.drawable.i_1,R.drawable.j_1,
            R.drawable.k_1,R.drawable.l_1,R.drawable.m_1,R.drawable.n_1,R.drawable.o_1,R.drawable.p_1,
            R.drawable.q_1,R.drawable.a_2,R.drawable.b_2,R.drawable.c_2,R.drawable.d_2,R.drawable.e_2,R.drawable.f_2,R.drawable.g_2,
            R.drawable.h_2,R.drawable.i_2,R.drawable.j_2,R.drawable.k_2,R.drawable.l_2 };
    public static String[] events_array={"Birthday","Birthday","Birthday","Birthday",
            "Birthday","Birthday","Birthday","Birthday","Birthday","Birthday","Birthday",
            "Birthday","Birthday","Birthday","Birthday","Birthday",
            "Birthday","Wedding","Wedding","Wedding","Wedding","Wedding","Wedding","Wedding","Wedding","Wedding","Wedding","Wedding","Wedding"};
    public static String[] category_array={"Kids","Kids","Kids","Kids","Male","Male","Female","Female","Male","Female","Male"
            ,"Female","Female","Male","Male","Kids","Kids","Female","Female","Male","Female","Male","Female","Male","Male","Male","Male","Female","Female"};
    public static String[] budget_array={"1499","652","1599","980","1099","1499","1530","506","720","750","599","2800","2735","2150",
            "2920","2732","2599","999","805","1100","1399","1432","1470","501","599","2499","2500","650","2284"};

    //farah iski array bana laina jo jo gift hai na site pai open kar kai uska url yahan paste karti jao
   public  static String link_array ="https://www.giftsnideas.com";


  //================================================================================================================
    //parse//code



    //===============================================================================================
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
            //setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        view_holer.nametxt.setText("Rs. " + gift.getName());
        view_holer.link.setOnClickListener(this);
        view_holer.img.setImageDrawable( gift.getImage() );
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