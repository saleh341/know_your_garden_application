package com.example.knowyourgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class postdetail extends AppCompatActivity {

    String[] PostDetail ={
            "Bacterial wilt, caused by numerous species of the genera Corynebacterium, Erwinia, Pseudomonas, and Xanthomonas, induces stunting, wilting, and withering, starting usually with younger leaves. Stems, which often shrivel and wither, show discoloured water-conducting tissue. A bacterial ooze is often evident when infected stems are cut and squeezed. Rapidly expanding, dark green, water-soaked areas or streaks may develop first in leaves.\n" +
                    "Bacterial wilt may be managed by growing resistant varieties; planting disease-free materials in well-drained, fertile soil that is clean or sterilized; observing stringent sanitation including weed- and insect-control measures; and rotating susceptible crops.All living organisms on Earth are made up of one of two basic types of cells: eukaryotic cells, in which the genetic material is enclosed within a nuclear membrane, or prokaryotic cells, in which the genetic material is not separated from the rest of the cell. Traditionally, all prokaryotic cells were called bacteria and were classified in the prokaryotic kingdom Monera. However, their classification as Monera, equivalent in taxonomy to the other kingdoms—Plantae, Animalia, Fungi, and Protista—understated the remarkable genetic and metabolic diversity exhibited by prokaryotic cells relative to eukaryotic cells. In the late 1970s American microbiologist Carl Woese pioneered a major change in classification by placing all organisms into three domains—Eukarya, Bacteria (originally called Eubacteria), and Archaea (originally called Archaebacteria)—to reflect the three ancient lines of evolution. The prokaryotic organisms that were formerly known as bacteria were then divided into two of these domains, Bacteria and Archaea. Bacteria and Archaea are superficially similar; for example, they do not have intracellular organelles, and they have circular DNA. However, they are fundamentally distinct, and their separation is based on the genetic evidence for their ancient and separate evolutionary lineages, as well as fundamental differences in their chemistry and physiology. " +
                    "Members of these two prokaryotic domains are as different from one another as they are from eukaryotic cells.\n"

            ,"anthracnose, a group of fungal diseases that affect a variety of plants in warm, humid areas. Shade trees such as sycamore, ash, oak, and maple are especially susceptible, though the disease is found in a number of plants, including grasses and annuals.\n" +
            "Anthracnose causes the wilting, withering, and dying of tissues. It commonly infects the developing shoots and leaves. The causative fungi (usually Colletotrichum or Gloeosporium) characteristically produce spores in tiny, sunken, saucer-shaped fruiting bodies known as acervuli. Symptoms include sunken spots or lesions (blight) of various colours in leaves, stems, fruits, or flowers, and some infections form cankers on twigs and branches. The severity of the infection depends on both the causative agent and the infected species and can range from mere unsightliness to death.\n" +
            "In the late 1970s a new form of the disease, known as dogwood anthracnose, was identified in North America. Unlike other forms of anthracnose, it thrives in cool climates. Dogwood anthracnose first appeared in the Pacific Northwest and soon spread to the eastern United States, eventually resulting in severe losses to natural stands of dogwoods in mountainous regions. The causative agent, the fungus Discula destructiva, was not described until 1991.\n" +
            "Anthracnose can be avoided by destroying diseased parts, using disease-free seed and disease-resistant varieties, applying fungicides, and controlling insects and mites that spread anthracnose fungi from plant to plant. For infections of annual plants, such as tomatoes or melons, crop rotation is suggested to limit the accumulation of fungal spores in the soil."

            ,"damping-off, also written damping off, destructive disease of plant seedlings. Damping-off is caused by a number of seed- and soil-borne fungi and funguslike oomycetes, including Rhizoctonia solani, Aphanomyces cochlioides, and species of Pythium, Phytophthora, Botrytis, Fusarium, Cylindrocladium, Diplodia, Phoma, and Alternaria. Given the diversity of the pathogens, damping-off can affect a wide range of plant species and can cause losses for a number of economically important food crops.\n" +
            "There are two types of damping-off: preemergence, in which sprouting seeds decay in soil and young seedlings rot before emergence; and postemergence, in which newly emerged seedlings suddenly wilt, collapse, and die from a soft rot at the soil line. Woody seedlings wilt and wither but remain upright; root decay often follows. Greatest losses occur in cold wet soils in which germination and emergence are slow, often in indoor conditions.\n" +
            "Damping-off can be avoided by starting seed in light, well-drained, well-prepared soil or sterile mix (containing perlite, peat moss, or vermiculite); treating soil with steam, dry heat or a fumigant; avoiding overcrowding, excessive shade, overwatering, too deep planting, and overfertilizing; and sowing crack-free, healthy seed dusted with fungicide seed protectant. An early outbreak can be controlled by applying a fungicide solution."


            ,"coffee rust, also called coffee leaf rust, devastating foliar disease of coffee plants caused by the fungus Hemileia vastatrix. Long known in coffee-growing areas of Africa, the Near East, India, Asia, and Australasia, coffee rust was discovered in 1970 to be widespread in Brazil, the first known infected area in the Western Hemisphere. Coffee rust destroyed the once-flourishing coffee plantations of Sri Lanka and Java in the late 1800s, and an epidemic in Central America and the Caribbean has decimated numerous plantations in the region since 2012.\n" +
            "The symptoms of coffee rust include small, yellowish, oily spots on the upper leaf surface that expand into larger round spots that turn bright orange to red and finally brown with a yellow border. The rust pustules are powdery and orange-yellow on the underleaf surface. Later the pustules turn black. Rusted leaves drop so that affected trees are virtually denuded; such trees have significantly lower coffee yields and usually die within a few years.\n" +
            "Coffee rust can be partially controlled by the timely application of fungicide sprays during wet seasons. Plantations in some areas have been moved to higher and cooler altitudes, 1,800 to 2,100 metres (6,000 to 7,000 feet), at which the rust fungus has difficulty reproducing, though global warming is expected to further the spread of the disease into these areas. There is evidence that shade-grown coffees, which are not grown as monocultures, are somewhat less susceptible, as the agroforestry practice of mixing tree crops greatly slows the spread of the disease. Additionally, resistant varieties of Robusta coffee (Coffea canefora) have been developed, but the beans are generally considered to be of lower quality than those of the vulnerable Arabica plants (C. arabica). One resistant variety, Lempira, was widely planted in Honduras but lost its resistance to the disease in 2017, resulting in crop losses in that country. No resistant varieties have shown to be impervious to all races of the fungus."

            ,"sooty mold, also called blotch or black mold, plant disease characterized by splotchy black stains or coatings on leaves, stems, and fruit. The black residue of sooty mold is composed of dark fungal threads of a number of ascomycetes, including species of Alternaria, Capnodium, Cladosporium, Fumago, and Scorias. These fungi grow in flowing sap or on honeydew excreted by aphids and other sucking insects. Although the condition is unsightly, it usually is not harmful. Control includes spraying or dusting for sucking insects, washing off sticky coatings of sap or honeydew on plant surfaces, and avoiding the wounding of plants.sooty mold, also called blotch or black mold, plant disease characterized by splotchy black stains or coatings on leaves, stems, and fruit. The black residue of sooty mold is composed of dark fungal threads of a number of ascomycetes, including species of Alternaria, Capnodium, Cladosporium, Fumago, and Scorias. These fungi grow in flowing sap or on honeydew excreted by aphids and other sucking insects. Although the condition is unsightly, it usually is not harmful. Control includes spraying or dusting for sucking insects, washing off sticky coatings of sap or honeydew on plant surfaces, and avoiding the wounding of plants."

           ,"disease of plant seedlings. Damping-off is caused by a number of seed- and soil-borne fungi and funguslike oomycetes, including Rhizoctonia solani, Aphanomyces cochlioides, and species of Pythium, Phytophthora, Botrytis, Fusarium, Cylindrocladium, Diplodia, Phoma, and Alternaria. Given the diversity of the pathogens, damping-off can affect a wide range of plant species and can cause losses for a number of economically important food crops.\\n\" +\n" +
            "\"There are two types of damping-off: preemergence, in which sprouting seeds decay in soil and young seedlings rot before emergence; and postemergence, in which newly emerged seedlings suddenly wilt, collapse, and die from a soft rot at the soil line. Woody seedlings wilt and wither but remain upright; root decay often follows. Greatest losses occur in cold wet soils in which germination and emergence are slow, often in indoor conditions.\\n\" +\n" +
            "\"Damping-off can be avoided by starting seed in light, well-drained, well-prepared soil or sterile mix (containing perlite, peat moss, or vermiculite);"


    };


    Integer[] imgid={
            R.drawable.d1,R.drawable.d2,
            R.drawable.d3,R.drawable.d4,
            R.drawable.d5,
            R.drawable.d6,R.drawable.d7,
            R.drawable.d8,R.drawable.d9,
            R.drawable.d10,
    };





    String[] DiseaseName={
          "Curly top","Aster Yellows","Bacterial Wilt","Dutch elm Disease","Panama Disease",
            "Curly top","Spotted Wilt","Chestnut Blight","Crown Gall"
    };

    String[] Postdate={
            "MONDAY  7  MAY ",
            "Tuesday  8  june",
            "Friday  10  April",
            "Sunday  17  August",
            "Wednesday  28  April",
            "Wednesday  11  April",
            "Monday  11  jan",
    };


//


    final int postdetailran = new Random().nextInt(((PostDetail.length-1) - 0) + 1) + 0;
    final int postimgid = new Random().nextInt(((imgid.length-1) - 0) + 1) + 0;
    final int postDiseaseName = new Random().nextInt(((DiseaseName.length-1) - 0) + 1) + 0;
    final int postPostdate = new Random().nextInt(((Postdate.length-1) - 0) + 1) + 0;
    final int postimgia= new Random().nextInt(((imgid.length-1) - 0) + 1) + 0;


    TextView textView3;
    EditText posttitle;
    TextView postdate;
    ImageView imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postdetail);

        getSupportActionBar().hide();

        textView3=(TextView)findViewById(R.id.postd);
        posttitle=(EditText)findViewById(R.id.posttitle);
        postdate=(TextView)findViewById(R.id.postdate);
        imageView6=(ImageView)findViewById(R.id.imageView6);




        textView3.setText(PostDetail[postdetailran]);
        posttitle.setText(DiseaseName[postDiseaseName]);
        postdate.setText(Postdate[postPostdate]);
        Resources res = getResources(); /** from an Activity */
        imageView6.setImageDrawable(res.getDrawable((R.drawable.blogimg)));



    }
}