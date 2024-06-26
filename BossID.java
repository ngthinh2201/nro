package com.girlkun.models.boss;


public class BossID {
    private BossID(){
    }
    
    //super đệ mabu
    
    // Đệ tử Fide
    public static final int KUKU = -1;
    public static final int MAP_DAU_DINH = -2;
    public static final int RAMBO = -3;
    //Doanh Trại
    public static final int TRUNG_UY_TRANG = -2_147_479_965;
    public static final int TRUNG_UY_XANH_LO = -2_147_479_964;
    public static final int TRUNG_UY_THEP = -2_147_479_963;
    public static final int NINJA_AO_TIM = -2_147_479_962;

    public static final int NINJA_AO_TIM_CLONE = -2_147_479_960;
    public static final int NINJA_AO_TIM_CLONE_MAX = -2_147_479_940;// max 20 con ngẫu nhiên

    public static final int ROBOT_VE_SI1 = -2_147_479_939;
    public static final int ROBOT_VE_SI2 = -2_147_479_938;
    public static final int ROBOT_VE_SI3 = -2_147_479_937;
    public static final int ROBOT_VE_SI4 = -2_147_479_936;

    public static boolean isBossNinjaClone(int id) {
        return (id >= NINJA_AO_TIM_CLONE && id <= NINJA_AO_TIM_CLONE_MAX);
    }

    public static boolean isBossRobotVeSi(int id) {
        return (id >= ROBOT_VE_SI1 && id <= ROBOT_VE_SI4);
    }
    
    public static final int NINJA_AO_TIM1 = -9;
    public static final int NINJA_AO_TIM2 = -10;
    public static final int NINJA_AO_TIM3 = -11;
    public static final int NINJA_AO_TIM4 = -12;
    
    //Tiểu Đội Sát Thủ
    public static final int SO_4 = -13;
    public static final int SO_3 = -14;
    public static final int SO_2 = -15;
    public static final int SO_1 = -16;
    public static final int TIEU_DOI_TRUONG = -17;
    public static final int TDST = -18;
    
    //Fide Đại Ca
    public static final int FIDE = -19;
    
    public static final int COOLER = -20;
    public static final int COOLER_GOLD = -21;
    public static final int VUA_COLD = -22;
    public static final int FIDE_ROBOT = -23;
    
    //Android
    public static final int ANDROID_13 = -24;
    public static final int ANDROID_14 = -25;
    public static final int ANDROID_15 = -26;
    
    public static final int ANDROID_19 = -27;
    public static final int DR_KORE = -28;

    public static final int PIC = -29;
    public static final int POC = -30;
    public static final int KING_KONG = -31;
    
    public static final int XEN_BO_HUNG = -32;
    public static final int SIEU_BO_HUNG = -33;
    public static final int XEN_CON_1 = -34;
    
    public static final int HIT = -35;
    public static final int CHILL_1 = -36;
    public static final int CHILL_2 = -37;
    public static final int HACHIYACK = -38;
    public static final int DR_LYCHEE = -39;

    public static final int MABU = -40;
    public static final int CUMBER = -41;
    public static final int BLACK3 = -42;
    public static final int AN_TROM = -43;
    
        public static final int Rong_1Sao = -224;
    public static final int Rong_2Sao = -225;
    public static final int Rong_3Sao = -226;
    public static final int Rong_4Sao = -227;
    public static final int Rong_5Sao = -228;
    public static final int Rong_6Sao = -229;
    public static final int Rong_7Sao = -230;
   

    //Broly
    public static final int BROLY = -44;
    public static final int BROLY_1 = -45;
    public static final int BROLY_2 = -46;
    public static final int BROLY_3 = -4699;
    public static final int BROLY_4 = -46666;
    public static final int GA_1 = -466166;
        public static final int SUPER_BROLY = -245;

    //Super 17 saga
    public static  final int SUPER_ANDROID_17 = -47;
    public  static final int DR_MYUU = -48;
    public  static final int DR_KORE_GT = -49;
    
    //Tàu Pảy Pảy
    public static  final int TAU_PAY_PAY_M = -51;

    //Mabu 12 giờ
    public static final int DRABURA = -50;
    public static final int BUI_BUI = -234;
    public static final int YA_CON = -235;
    public static final int MABU_12H = -236;
    public static final int DRABURA_2 = -237;
    public static final int BUI_BUI_2 = -238;
    
    // Black Goku - Tương Lai
    public static final int BLACK = -203;
    public static final int BLACK1 = -241;
    public static final int BLACK2 = -242;
    public static final int ZAMASMAX = -243;
    public static final int ZAMASZIN = -244;
     public static final int detu1 = -2424;
     public static final int DETU = -2414;
     public static final int SUPER_BROLY24 = -2434;

 
      public static final int hit = -334;
      public static final int robotor = -1334;
         //bọ cánh cứng
    public static final int CON_BO_1 = -2037;
    public static final int CON_BO_2 = -2461;
    public static final int bocung1 = -2431;
       public static final int bocung2 = -2631;
    
    //Đại Hội Võ Thuật 23
    public static final byte SOI_HEC_QUYN = -77;
    public static final byte O_DO = -78;
    public static final byte XINBATO = -79;
    public static final byte CHA_PA = -80;
    public static final byte PON_PUT = -81;
    public static final byte CHAN_XU = -82;
    public static final byte TAU_PAY_PAY = -83;
    public static final byte YAMCHA = -84;
    public static final byte JACKY_CHUN = -85;
    public static final byte THIEN_XIN_HANG = -86;
    public static final byte LIU_LIU = -87;
    public static final byte THIEN_XIN_HANG_CLONE = -88;
    public static final byte THIEN_XIN_HANG_CLONE1 = -89;
    public static final byte THIEN_XIN_HANG_CLONE2 = -90;
    public static final byte THIEN_XIN_HANG_CLONE3 = -91;
    
//    bosslinh tinh
     public static final byte BROLY_BASE_SUPER = -92;
     public static final byte GOHANHN = -93;
     public static final byte GOKUHN = -94;
     public static final byte FIDEGOLD = -95;
     public static final byte FIDEGOLD_1 = -96;
     public static final byte CHILL = -97;
     public static final byte CHILL1 = -98;
     public static final byte SUPER_BROLY2 = -100;
     public static final byte BROLY_THUONG2 = -101;
     public static final int MAI = -35000;
     public static final int PILAP = -36000;
     public static final int SU = -37000;
        public static final int DETU0 = -99;
        //giangho
    public static final int SOI_GIANGHO = -1000;
    public static final int ODO_GIANGHO = -1001;
    public static final int XINBATO_GIANGHO = -1002;
    public static final int CHACHA_GIANGHO = -1003;
    public static final int PONPUT_GIANGHO = -1004;
    public static final int CHANXU_GIANGHO = -1005;
    public static final int TAUPAYPAY_GIANGHO = -1006;
    public static final int YAMCHA_GIANGHO = -1007;
    public static final int JACKYCHUN_GIANGHO = -1008;
    public static final int THIENXINHANG_GIANGHO = -1009;
    public static final int GIANGHO = -1010;  
    //huydiet
    public static final int THAN_HUY_DIET = -239;
    public static final int THIEN_SU_WHIS = -240;
    public static final int THAN_HUY_DIET_CHAMPA = -245;
    public static final int THIEN_SU_VADOS = -246;
    //   Biệt Đội Báo Thủ Doraemon
    public static final int DORAEMON = -222;
    public static final int NOBITA = -212;
    public static final int XUKA = -220;
    public static final int CHAIEN = -219;
    public static final int XEKO = -218;
    public static final int DORAEMON_TEAM = -2300;
        //BASIL
    public static final int BASIL = -12000;
    public static final int LAVENDE = -12001;
    public static final int BERGAMO = -12002;
    public static final int BACONSOI = -12003;
        //Vo dai hat mit
    public static final int DRACULA = -10000;
    public static final int NGUOIVOHINH = -10001;
    public static final int BONGBANG = -10002;
    public static final int SATAN = -10003; 
    public static final int THODAUBAC = -10004;
    public static final int Vodaihatmit = -1011;
        //
    public static final int ZENO_VANG = -18001;
    public static final int ZENO_XANH = -18000;
    public static final int ZENO_TIM = -18002;
    public static final int ZENO= -18004;
    
    //
        public static final int FROST = -2004;
    public static final int FROST_1 = -2005;
    public static final int FROST_2 = -2005;
    public static final int FROST_3 = -2005;
    
    
}






















