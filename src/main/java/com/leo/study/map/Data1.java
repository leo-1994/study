package com.leo.study.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chao.li@quvideo.com
 * @date 2019-05-30 17:19
 */
public class Data1 {
    public static void main(String[] args) {
        String d = "25302403,25557126,9551771,25818247,22942284,21908824,13928445,19654912,8802730,24696393,25707209,23077692,17762411,18105726,21525284,24864258,24419595,28494797,22702280,25879827,23922605,18819030,17173452,4366996,26092377,20442093,22146484,18900935,14657847,23117194,14104613,24942475,21075901,25006460,25302403,21908824,7332941,14456056,25700258,507433,27841415,25458102,21136767,28568041,23077692,23808308,17507693,26547187,18105726,23695642,27466712,22046509,24419595,26772241,25879827,23561126,18819030,20989840,12805654,26092377,20442093,26083664,1418997,22146484,18900935,23117194,22003131,21691827,21075901,17345012,6805350,25557126,25818247,22942284,26812033,16157674,26288780,17609252,13928445,24696393,19103847,24582715,19408504,22946318,12078060,684371,24458287,13510546,17762411,1581943,22150690,11254239,12907441,24864258,568181,16647553,760180,27303456,23203042,22702280,12227870,28265593,3947491,26561610,14657847,4027845,27102823,25006460,20355376,24168311,28289958,972318,12190891,23906686,24917861,25423261,28715411,15491269,19654912,18383670,25722791,21136767,15744177,15982264,25690058,18874188,15416497,20919141,27678715,26928581,19367800,8910565,12348122,15430285,18235258,23281427,12404942,13811873,23695642,27466712,24419595,18003350,26463511,15494251,14159455,26772241,9421317,18685334,13568085,8500762,16762461,28283661,27366175,23561126,23920558,27758946,4934787,18819030,17173452,20989840,25687379,12805654,3879662,1946311,1418997,7566482,20531666,15651842,14104613,24942475,21313468,15376405,20906040,25686671,9551771,27606184,12331948,20554785,16157674,12572579,3887391,20029977,17609252,19441157,24696393,17120310,12514182,8661949,14280165,21090940,17180230,28218092,24005158,8591816,7767355,22946318,684371,6168320,17762411,6381325,1581943,13473727,28653254,14069154,11254239,11777991,24864258,760180,20514490,3656627,22702280,12689237,27098631,10657085,13526886,14162290,18727602,28909590,4466676,14687058,15345491,25902159,17430212,5660034,26416710,28265593,15907109,25663056,22252682,15972136,6672827,26561610,8649568,15994128,27928130,25857138,17191675,25314722,29086005,17963946,29025147,20434394,26774700,28565636,25365742,29264593,29261373,28526513,19997503,14935792,8338531,29144481,11154059,29221275,23762242,27218351,28239255,29117314,29180925,144960,28547569,29262326,29259767,18653518,4717076,8172073,29131747,29258718,28632017,28099032,28288468,28101932,29236031,29077308,18642331,26495772,27516715,28595007,29304115,29086005,5065439,28714789,29009709,13695050,10744835,29121815,28206336,29324047,28964109,17963946,29308678,3059947,28904305,15695908,5307549,29178733,28623713,20548590,28963682,22842243,7487661,28285263,28587346,7052930,12148309,20434394,27562327,28760399,28706125,12890680,17516022,23177630,29309628,21725762,21222985,26751639,29148339,28579984,3149085,29301390,8099144,26774700,28565636,23295026,29293805,23546931,27524861,8607202,27561669,27716290,25365742,29264593,15915907,11055066,4918591,1276261,12148175,29258440,29307078,28527816,27990224,3586891,29114561,13423438,20464828,28827174,28291643,29092908,28885026,9449227,27151361,29326368,27987969,15767899,29072907,28633601,24194244,28844671,28617342,29289587,29275761,27201612,29303401,8201642,8386471,14255365,28896868,28436076,28287566,19216582,17047776,29171285,29038673,28909653,17449205,28526513,5773403,26541968,18151709,21908824,12812500,29247906,25314722,17231652,26790842,28889501,23092549,28952464,28515737,24064321,25458102,24733003,6306389,26644385,15771850,8080448,29180925,18156371,29305847,29262326,29259767,27866595,15982264,22184222,2991712,29244401,28702692,18653518,28879852,23077692,28939237,23808308,29131747,28689367,17507693,26547187,27731392,13997234,28468696,28288468,28494797,28101932,28927802,27516715,26495772,29304115,29086005,25106929,29009709,1207434,29315877,13695050,8500762,29153575,24096242,10744835,16762461,21005286,21623269,24626650,28206336,29324047,28964109,27783442,29262085,29325056,23922605,22561688,10729056,3059947,25288519,23110568,18819030,17173452,28368766,20989840,29178733,28807522,4366996,29022572,26092377,20548590,24992165,29303654,20442093,28699496,26083664,28677482,28285263,22146484,18900935,20434394,28799321,14104613,29260618,20342721,28706125,12890680,26541418,28891839,9551771,25818247,26751639,24115834,29315242,3834658,26288780,10444162,28963481,28579984,24422481,27469958,20928538,19346433,28794512,13928445,29281940,8802730,3149085,24696393,29168780,28960397,17974308,28565636,18836516,27978391,28801161,28591755,29189762,29283067,24582715,22946318,29297903,26641094,29260010,28162299,24458287,6463294,24575530,29330654,29297372,29028574,27716290,21170728,1581943,29264593,15915907,11055066,22150690,4918591,1276261,29294281,19661398,27990224,28527816,29317315,27303456,13423438,28924478,27699245,18620045,28827174,22702280,28291643,29092908,29281318,9449227,28019208,12227870,21296354,27987969,29259283,29292556,26742316,28633601,21625586,28382732,348090,5924837,28976252,28844671,28265593,8386471,28635759,28896868,28682856,29262432,3947491,11608912,17047776,28326997,15629572,17666790,14906638,28941908,29278797,4027845,29300802,25302403,25006460,5773403,26113421,802825,18151709,26432926,29285296,9684609,29326252,28690336,21908824,29290404,28545964,25314722,29266846,23092549,28715411,23762242,24403804,19654912,24064321,27218351,28041113,24733003,29317517,26971053,27739547,21136767,28410254,27553179,28891640,144960,17956185,27524586,27253716,15982264,22184222,28925431,29244401,18653518,28848618,23077692,18724223,28632017,17507693,26547187,18105726,21525284,23695642,28099032,11066590,980596,20474808,28226351,10915367,7973626,29077308,27516715,26772241,29271861,18636183,29086005,28080445,5065439,24289766,29009709,25879827,13695050,29153575,24096242,28810007,28914971,16762461,5456631,28206336,29330192,21924833,20646282,28964109,12758649,29331201,29096709,28807543,29025147,23561126,28983165,18819030,17173452,23628195,28368766,29178733,20989840,28865901,28807522,4366996,26092377,19297276,20442093,28963682,23062403,28699496,26083664,28285263,25822570,17498089,22146484,20363728,28587346,23902602,18900935,18455536,29269332,24992656,28285248,14104613,28934989,24942475,26541418,23177630,25557126,20346421,21159494,11510697,21638221,9551771,24657526,25818247,29148339,3755304,22942284,24115834,26812033,26288780,28738729,20197398,29253789,28579984,24422481,19346433,20365329,13928445,29281940,8802730,27566731,29301390,29168780,26774700,18836516,27978391,29019781,19103847,29283067,24582715,22946318,19408504,23546931,28873967,868181,13510546,6168320,29330654,3640149,13017506,28627672,6381325,25365742,29295312,1581943,26925803,22150690,4918591,29264587,1276261,22854699,24864258,19661398,27990224,29114561,760180,16647553,27303456,13423438,29261373,20514490,20464828,29297721,28924478,22702280,29092908,28019208,12227870,21296354,15767899,4298730,27893254,10293554,21011697,29265932,27996702,25256503,21625586,28362353,17338569,29289587,29275761,29087337,28265593,29110374,28635759,29284451,26561610,19216582,15629572,24727188,18883279,7803777,29329481,4027845,25857138,27935827,17449205,19462952,25302403,25006460,26541968,28490166,18151709,26432926,21908824,25314722,27576708,11154059,25751968,19654912,7857754,24064321,507433,29317517,25458102,29288330,26644385,28239255,28872580,21136767,28891640,144960,28547569,18156371,29055997,17956185,27019732,7479867,27866595,23404331,28848618,18653518,8172073,23077692,26928581,19367800,28210639,28689367,18724223,28632017,18165104,3247191,17507693,26547187,29268951,18105726,21525284,23422217,436329,29326285,28099032,20176709,18695525,28288468,22046509,24419595,26360083,29236031,27516715,7653117,18636183,25106929,27967269,5065439,28714789,29009709,25879827,13695050,19801012,24096242,10744835,28914971,27539718,16762461,5456631,21005286,17945018,4785892,28206336,26449725,20646282,7353033,23922605,23561126,27927400,10729056,23189413,25288519,28904305,17173452,5307549,29178733,20989840,15262268,28807522,4366996,10405449,29265769,26092377,24992165,29303654,20442093,26083664,28677482,22545799,28285263,22146484,28587346,18900935,18455536,23117194,12148309,1505531,14104613,15255579,29260618,28934989,22003131,20342721,24942475,21075901,28592970,26541418,29333824,24479351,21638221,26328214,9551771,25818247,22942284,27864767,29259945,9440689,29265564,29290141,29253789,28579984,20928538,27469958,24422481,27171511,13928445,29281940,8802730,27566731,29168780,1265441,28960397,5711713,28565636,27978391,9305035,13544841,24582715,26722009,22946318,23295026,868181,6463294,18797635,6168320,29297372,29168350,29265623,28629720,25365742,1581943,11055066,22150690,4918591,29264587,12907441,22854699,24864258,28527816,568181,16647553,760180,10625314,27303456,29261373,29297721,28924478,24761072,7740408,29305391,22702280,9449227,11228983,27151361,12227870,21296354,27987969,15767899,4298730,28778523,27893254,29299728,29272079,21011697,21715198,21625586,29265921,28362353,28844671,17376974,16077628,29289587,28265593,28896868,28436076,29284451,3947491,26561610,26645065,15876371,29038673,28941908,14906638,27102823,17449205,29267009,19462952,25302403,17613582,21737807,23625071,24168311,18151709,28289958,29295540,26432926,28743079,29326252,26640770,12812500,2437691,25423261,25314722,11154059,18904835,23762242,28515737,19654912,24064321,29018004,1955373,26644385,20983160,27662748,21136767,21819762,28891640,144960,29305847,27019732,17956185,29259767,27866595,29083120,22184222,28848618,28879852,7476776,23077692,633430,26547187,17507693,18105726,23858950,6795789,28491228,27616725,23695642,28099032,29228488,20176709,27466712,26149875,24419595,28101932,26360083,29236031,24242163,13981789,7653117,26772241,29284148,29086005,29134633,29261611,26271495,25879827,13695050,10744835,5456631,28308232,17945018,29121815,27709197,24626650,20646282,20151681,27783442,12758649,23922605,22193554,29025147,11124843,5985948,26185030,16987597,12267124,20989840,28807522,4366996,26092377,24992165,29303654,20442093,28963682,23062403,26083664,22146484,18900935,23117194,1505531,24992656,14104613,15255579,27562327,20342721,24942475,21691827,24386172,9551771,25818247,3755304,22942284,26812033,29292705,28558994,28579984,20365329,20029977,28595869,13928445,13129700,8802730,3149085,22440571,27987589,29168780,24696393,28565636,20858374,18836516,27978391,27344543,25707209,29260020,24582715,22946318,19408504,29293805,12078060,13510546,18797635,6168320,28563155,27561669,13017506,29028574,27579596,29285588,25365742,16742287,15915907,11055066,28119774,22150690,4918591,1276261,27990224,3586891,568181,760180,16647553,27303456,28391984,20464828,25124601,28924478,29320246,6346220,26185730,28827174,18620045,22702280,29092908,26522125,9449227,28171313,11228983,27151361,11003142,28925976,12227870,21296354,27987969,29299728,29292556,27996702,8186825,25256503,21625586,348090,6991274,28362353,28976252,28889713,26898512,19566311,28265593,20972187,11110773,29262432,27839095,26561610,29282910,11608912,15629572,28941908,14906638,29190222,25857138,29300802,25302403,21737807,23625071,24168311,9076864,15997694,25704344,28743079,23368054,28690336,21908824,12812500,28545964,25314722,28889501,28353431,28944273,24403804,19654912,24064321,27322256,28041113,25458102,6306389,26644385,23699285,21136767,28891640,29055997,27019732,27524586,27866595,20037498,20771696,22184222,29244401,20610926,28231160,23077692,29131747,28689367,28616146,26547187,18105726,23422217,28491228,23695642,12661940,26926061,28288468,27466712,24419595,28101932,11579441,26360083,28927802,29077308,7653117,26772241,29284148,18636183,25879827,28440875,29153575,24096242,10744835,16762461,3252370,5456631,26449725,20646282,27783442,7353033,29096709,23922605,29025147,27927400,15830069,25288519,29050236,18819030,17173452,18654160,20989840,29082479,22681486,28865901,4366996,26092377,24992165,27837808,20442093,23062403,26083664,28677482,1418997,22146484,18900935,18455536,23117194,1505531,24992656,14104613,22003131,29315914,29111625,24942475,21691827,28706125,26541418,6805350,25557126,9551771,3847473,24657526,22942284,26812033,16157674,9440689,29290141,886062,28579984,20928538,13928445,29281940,27987589,18976273,29168780,24696393,19971589,17974308,28565636,20858374,18836516,27978391,28801161,29189762,25707209,19103847,23348780,24582715,22946318,28162299,28999394,868181,22093323,13510546,18797635,13017506,9863666,25365742,1581943,16742287,15915907,28119774,22150690,11254239,24864258,28520655,568181,28651569,25124601,6346220,18620045,22702280,29092908,9449227,27151361,12227870,27987969,15767899,27893254,14687058,8186825,26106931,348090,10977126,23561378,27248209,29199986,27340913,28265593,15907109,8386471,28866662,26645065,3947491,2300866,28364886,14657847,25040530,29190222,7803777";
        String[] a = d.split(",");
        Set<String> set = new HashSet<>(Arrays.asList(a));
        set.forEach(System.out::println);
    }
}