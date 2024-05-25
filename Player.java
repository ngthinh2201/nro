package com.girlkun.models.player;

import BoMong.BoMong;
import com.arriety.card.Card;
import com.girlkun.models.map.MapMaBu.MapMaBu;
import com.girlkun.models.skill.PlayerSkill;

import java.util.List;

import com.girlkun.models.clan.Clan;
import com.girlkun.models.intrinsic.IntrinsicPlayer;
import com.girlkun.models.item.Item;
import com.girlkun.models.item.ItemTime;
import com.girlkun.models.npc.specialnpc.MagicTree;
import com.girlkun.consts.ConstPlayer;
import com.girlkun.consts.ConstTask;
import com.girlkun.models.npc.specialnpc.MabuEgg;
import com.girlkun.models.mob.MobMe;
import com.girlkun.data.DataGame;
import com.girlkun.models.Template;
import com.girlkun.models.clan.ClanMember;
import com.girlkun.models.map.BDKB.BanDoKhoBauService;
import com.girlkun.models.map.TrapMap;
import com.girlkun.models.map.Zone;
//import com.girlkun.models.yadat.Yadat;
import com.girlkun.models.map.blackball.BlackBallWar;
import com.girlkun.models.matches.IPVP;
import com.girlkun.models.matches.TYPE_LOSE_PVP;
import com.girlkun.models.matches.TYPE_PVP;
import com.girlkun.models.matches.pvp.DaiHoiVoThuat;
import com.girlkun.models.npc.specialnpc.BillEgg;
import com.girlkun.models.skill.Skill;
import com.girlkun.server.Manager;
import com.girlkun.services.Service;
import com.girlkun.server.io.MySession;
import com.girlkun.models.task.TaskPlayer;
import com.girlkun.network.io.Message;
import com.girlkun.server.Client;
import com.girlkun.services.EffectSkillService;
import com.girlkun.services.FriendAndEnemyService;
import com.girlkun.services.PetService;
import com.girlkun.services.TaskService;
import com.girlkun.services.func.ChangeMapService;
import com.girlkun.services.func.ChonAiDay;
import com.girlkun.services.func.CombineNew;
import com.girlkun.services.func.TopService;
import com.girlkun.utils.Logger;
import com.girlkun.utils.Util;
import java.util.HashMap;

import java.util.ArrayList;
import com.girlkun.models.mob.Mob;
import com.girlkun.services.PlayerService;
import com.girlkun.network.io.Message;
import com.girlkun.services.SkillService;
import com.girlkun.utils.SkillUtil;

public class Player {

    public int luotNhanBuaMienPhi = 1;

    public MySession session;

    public boolean beforeDispose;

    public boolean isBot = false;
    public boolean isPet;
    public boolean isNewPet;
    public boolean isBoss;
    public boolean isYadat;
    public int NguHanhSonPoint = 0;
    public IPVP pvp;
    public int pointPvp;
    public int sukien_mtv = 0;
    public byte maxTime = 30;
    public byte type = 0;

    public List<Integer> idEffChar = new ArrayList<>();
    // danh hieu
    public byte capCS;
    public byte capTT;
    public boolean titleitem;
    public boolean titlett;
    public boolean isTitleUse;
    public long lastTimeTitle;
    public boolean isBuNhin = false;
    public boolean haveNhanBan;

    public int countOpenBox;
    public int mapIdBeforeLogout;
    public List<Zone> mapBlackBall;
    public List<Zone> mapMaBu;
    public long limitgold = 0;
    public Zone zone;
    public Zone mapBeforeCapsule;
    public List<Zone> mapCapsule;
    public Pet pet;
    public NewPet newpet;
    public MobMe mobMe;
    public Location location;
    public SetClothes setClothes;
    public EffectSkill effectSkill;
    public MabuEgg mabuEgg;
    public BillEgg billEgg;
    public TaskPlayer playerTask;
    public ItemTime itemTime;
    public Fusion fusion;
    public MagicTree magicTree;
    public IntrinsicPlayer playerIntrinsic;
    public Inventory inventory;
    public PlayerSkill playerSkill;
    public CombineNew combineNew;
    public IDMark iDMark;
    public Charms charms;
    public EffectSkin effectSkin;
    public NPoint nPoint;
    public RewardBlackBall rewardBlackBall;
    public EffectFlagBag effectFlagBag;
    public FightMabu fightMabu;
    public SkillSpecial skillSpecial;
    public Clan clan;
    public ClanMember clanMember;
    public boolean haveChangeFlagNamec;

    public List<Friend> friends;
    public List<Enemy> enemies;

    public long id;
    public String name;
    public byte gender;
    public boolean isNewMember;
    public short head;

    public byte typePk;

    public byte cFlag;

    public boolean haveTennisSpaceShip;

    public boolean justRevived;
    public long lastTimeRevived;

    public boolean banv = false;
    public boolean muav = false;
    public long timeudbv = 0;
    public long timeudmv = 0;
    public long lasttimebanv;
    public long lasttimemuav;

    public int violate;
    public byte totalPlayerViolate;
    public long timeChangeZone;
    public long lastTimeUseOption;

    public boolean isGotoFuture;
    public long lastTimeGoToFuture;

    public short idNRNM = -1;
    public short idGo = -1;
    public long lastTimePickNRNM;
    public int goldNormar;
    public int goldVIP;
    public long lastTimeWin;
    public boolean isWin;
    public List<Card> Cards = new ArrayList<>();
    public short idAura = -1;
    public int vnd;
    public int gioithieu;
    public int VND;
    public int levelWoodChest;
    public boolean receivedWoodChest;
    public int goldChallenge;

    public int bdkb_countPerDay;
    public long bdkb_lastTimeJoin;
    public boolean bdkb_isJoinBdkb;

    public byte indexMenuThuongNap;
    public int gtPoint;

    public Player() {
        lastTimeUseOption = System.currentTimeMillis();
        location = new Location();
        nPoint = new NPoint(this);
        inventory = new Inventory();
        playerSkill = new PlayerSkill(this);
        setClothes = new SetClothes(this);
        effectSkill = new EffectSkill(this);
        fusion = new Fusion(this);
        playerIntrinsic = new IntrinsicPlayer();
        rewardBlackBall = new RewardBlackBall(this);
        effectFlagBag = new EffectFlagBag();
        fightMabu = new FightMabu(this);
        //----------------------------------------------------------------------
        iDMark = new IDMark();
        combineNew = new CombineNew();
        playerTask = new TaskPlayer();
        friends = new ArrayList<>();
        enemies = new ArrayList<>();
        itemTime = new ItemTime(this);
        charms = new Charms();
        effectSkin = new EffectSkin(this);
        skillSpecial = new SkillSpecial(this);
        achievement = new BoMong(this);
    }

    //--------------------------------------------------------------------------
    public boolean isDie() {
        if (this.nPoint != null) {
            return this.nPoint.hp <= 0;
        }
        return true;
    }

    //--------------------------------------------------------------------------
    public void setSession(MySession session) {
        this.session = session;
    }

    public void sendMessage(Message msg) {
        if (this.session != null) {
            session.sendMessage(msg);
        }
    }

    public boolean isTargerDe(Player plAtt) {
        return plAtt.isNewPet || plAtt.isBoss || plAtt.isPl();
    }

    public MySession getSession() {
        return this.session;
    }

    public boolean isPl() {
        return !isPet && !isBoss && !isNewPet;
    }

    public void update() {
        if (this.isBot) {
            active();
        }
        if (this != null && this.name != null && !this.beforeDispose && !isBot) {
            try {
                if (!iDMark.isBan()) {
                    if (this != null) {
                        if (nPoint != null) {
                            nPoint.update();
                        }
                        if (fusion != null) {
                            fusion.update();
                        }
                        if (effectSkin != null) {
                            effectSkill.update();
                        }
                        if (mobMe != null) {
                            mobMe.update();
                        }
                        if (effectSkin != null) {
                            effectSkin.update();
                        }
                        if (pet != null) {
                            pet.update();
                        }
                        if (newpet != null) {
                            newpet.update();
                        }

                        if (magicTree != null) {
                            magicTree.update();
                        }
                        if (itemTime != null) {
                            itemTime.update();
                        }

                        BlackBallWar.gI().update(this);
                        MapMaBu.gI().update(this);

                        //-------------------------------------------------------
                        if (this.nPoint.power > 200 && this.nPoint.power < 1500000000000L) {
                            if (idEffChar.contains(28)) {
                                Service.gI().removeEff(this, 57, 58, 73, 64, 66, 67, 68, 60, 84, 85, 86, 206);
                            }
//                        Service.gI().addEffectChar(this, 66, 1, -1, -1, 0);
//                        Service.gI().addEffectChar(this, 57, 1, -1, -1, 0);
//                        Service.gI().addEffectChar(this, 58, 1, -1, -1, 0);
//                        Service.gI().addEffectChar(this, 73, 1, -1, -1, 0);
//                        Service.gI().addEffectChar(this, 64, 1, -1, -1, 0);              
//                        Service.gI().addEffectChar(this, 67, 1, -1, -1, 0);   
//                        Service.gI().addEffectChar(this, 84, 1, -1, -1, 0);
//                        Service.gI().addEffectChar(this, 85, 1, -1, -1, 0);
//                        Service.gI().addEffectChar(this, 86, 1, -1, -1, 0);
//                        Service.gI().addEffectChar(this, 68, 1, -1, -1, 0);              
//                        Service.gI().addEffectChar(this, 60, 1, -1, -1, 0);    
//                        Service.gI().addEffectChar(this, 206, 1, -1, -1, 0);  
                        }
                        //------------------------------------

                        if (this.iDMark != null) {
                            if (!isBoss && this.iDMark.isGotoFuture() && Util.canDoWithTime(this.iDMark.getLastTimeGoToFuture(), 6000)) {
                                ChangeMapService.gI().changeMapBySpaceShip(this, 102, -1, Util.nextInt(60, 200));
                                this.iDMark.setGotoFuture(false);
                            }

                            if (this.iDMark.isGoToBDKB() && Util.canDoWithTime(this.iDMark.getLastTimeGoToBDKB(), 6000)) {
                                ChangeMapService.gI().changeMapBySpaceShip(this, 135, -1, 35);
                                this.iDMark.setGoToBDKB(false);
                            } else if (!isBoss && this.iDMark.isGoToKGHD() && Util.canDoWithTime(this.iDMark.getLastTimeGoToKGHD(), 6000)) {
                                ChangeMapService.gI().changeMapInYard(this, 149, -1, Util.nextInt(60, 200));
                                this.iDMark.setGoToKGHD(false);
//                            } else if (!isBoss && this.iDMark.isGoToCDRD() && Util.canDoWithTime(this.iDMark.getLastTimeGoToCDRD(), 1000)) {
//                                ChangeMapService.gI().changeMapInYard(this, 143, -1, 1108);
//                                this.iDMark.setGoToCDRD(false);
                            }
                        }

                        if (this.zone != null) {
                            TrapMap trap = this.zone.isInTrap(this);
                            if (trap != null) {
                                trap.doPlayer(this);
                            }
                        }

                        if ((this.isPl() || this.isPet) && this.inventory.itemsBody.size() == 13
                                && this.inventory.itemsBody.get(7) != null) {
                            Item it = this.inventory.itemsBody.get(7);
                            if (it != null && it.isNotNullItem() && this.newpet == null) {
                                PetService.Pet2(this, it.template.head, it.template.body, it.template.leg,
                                        it.template.name);

                                Service.getInstance().point(this);
                            }
                        } else if ((this.isPl() || this.isPet) && this.inventory.itemsBody.size() == 13 && newpet != null
                                && !this.inventory.itemsBody.get(7).isNotNullItem()) {
                            newpet.dispose();
                            newpet = null;
                        }
                        if ((this.isPl() || this.isPet) && this.inventory.itemsBody.size() == 13
                                && this.inventory.itemsBody.get(11) != null) {
                            Item it = this.inventory.itemsBody.get(11);
                            if (it != null && it.isNotNullItem()) {
                                if (it.template.type == 35) {
                                    Service.gI().sendFoot(this, it.template.part);
                                }
                                Service.getInstance().sendFlagBag(this);
                            }
                        }
                        if ((this.isPl() || this.isPet) && this.inventory.itemsBody.size() == 13
                                && this.inventory.itemsBody.get(12) != null) {
                            Item it = this.inventory.itemsBody.get(12);
                            if (it != null && it.isNotNullItem()) {
                                if (it.template.type == 36) {
                                    Service.gI().sendTitle(this, it.template.part);
                                }
                                Service.getInstance().sendFlagBag(this);
                            }
                        } else if (this.isPl() && newpet != null && !this.inventory.itemsBody.get(7).isNotNullItem()) {
                            ChangeMapService.gI().exitMap(newpet);
                            newpet.dispose();
                            newpet = null;
                        }

                        ///
                        if (this.isPl() && isWin && this.zone.map.mapId == 51 && Util.canDoWithTime(lastTimeWin, 2000)) {
                            ChangeMapService.gI().changeMapBySpaceShip(this, 52, 0, -1);
                            isWin = false;
                        }
                        if (location.lastTimeplayerMove < System.currentTimeMillis() - 30 * 60 * 1000) {
                            Client.gI().kickSession(getSession());
                        }
                    } else {
                        if (Util.canDoWithTime(iDMark.getLastTimeBan(), 5000)) {
                            Client.gI().kickSession(session);
                        }
                    }
                } else {

                }
            } catch (Exception e) {
                e.getStackTrace();
                Logger.logException(Player.class, e, "Lỗi tại player: " + this.name);
            }
        }
    }

    //--------------------------------------------------------------------------
    /*
     * {380, 381, 382}: ht lưỡng long nhất thể xayda trái đất
     * {383, 384, 385}: ht porata xayda trái đất
     * {391, 392, 393}: ht namếc
     * {870, 871, 872}: ht c2 trái đất
     * {873, 874, 875}: ht c2 namếc
     * {867, 878, 869}: ht c2 xayda
     */
    private static final short[][] idOutfitFusion = {
        {380, 381, 382}, //luong long
        {383, 384, 385},// porata 
        {391, 392, 393}, //hop the chung namec
        {870, 871, 872},//trai dat c2
        {873, 874, 875}, //namec c2
        {867, 868, 869} //xayda c2
    };

    public byte getEffFront() {
        if (this.inventory.itemsBody.isEmpty() || this.inventory.itemsBody.size() < 10) {
            return -1;
        }
        int levelAo = 0;
        Item.ItemOption optionLevelAo = null;
        int levelQuan = 0;
        Item.ItemOption optionLevelQuan = null;
        int levelGang = 0;
        Item.ItemOption optionLevelGang = null;
        int levelGiay = 0;
        Item.ItemOption optionLevelGiay = null;
        int levelNhan = 0;
        Item.ItemOption optionLevelNhan = null;
        Item itemAo = this.inventory.itemsBody.get(0);
        Item itemQuan = this.inventory.itemsBody.get(1);
        Item itemGang = this.inventory.itemsBody.get(2);
        Item itemGiay = this.inventory.itemsBody.get(3);
        Item itemNhan = this.inventory.itemsBody.get(4);
        for (Item.ItemOption io : itemAo.itemOptions) {
            if (io.optionTemplate.id == 72) {
                levelAo = io.param;
                optionLevelAo = io;
                break;
            }
        }
        for (Item.ItemOption io : itemQuan.itemOptions) {
            if (io.optionTemplate.id == 72) {
                levelQuan = io.param;
                optionLevelQuan = io;
                break;
            }
        }
        for (Item.ItemOption io : itemGang.itemOptions) {
            if (io.optionTemplate.id == 72) {
                levelGang = io.param;
                optionLevelGang = io;
                break;
            }
        }
        for (Item.ItemOption io : itemGiay.itemOptions) {
            if (io.optionTemplate.id == 72) {
                levelGiay = io.param;
                optionLevelGiay = io;
                break;
            }
        }
        for (Item.ItemOption io : itemNhan.itemOptions) {
            if (io.optionTemplate.id == 72) {
                levelNhan = io.param;
                optionLevelNhan = io;
                break;
            }
        }
        if (optionLevelAo != null && optionLevelQuan != null && optionLevelGang != null && optionLevelGiay != null && optionLevelNhan != null
                && levelAo >= 8 && levelQuan >= 8 && levelGang >= 8 && levelGiay >= 8 && levelNhan >= 8) {
            return 8;
        } else if (optionLevelAo != null && optionLevelQuan != null && optionLevelGang != null && optionLevelGiay != null && optionLevelNhan != null
                && levelAo >= 7 && levelQuan >= 7 && levelGang >= 7 && levelGiay >= 7 && levelNhan >= 7) {
            return 7;
        } else if (optionLevelAo != null && optionLevelQuan != null && optionLevelGang != null && optionLevelGiay != null && optionLevelNhan != null
                && levelAo >= 6 && levelQuan >= 6 && levelGang >= 6 && levelGiay >= 6 && levelNhan >= 6) {
            return 6;
        } else if (optionLevelAo != null && optionLevelQuan != null && optionLevelGang != null && optionLevelGiay != null && optionLevelNhan != null
                && levelAo >= 5 && levelQuan >= 5 && levelGang >= 5 && levelGiay >= 5 && levelNhan >= 5) {
            return 5;
        } else if (optionLevelAo != null && optionLevelQuan != null && optionLevelGang != null && optionLevelGiay != null && optionLevelNhan != null
                && levelAo >= 4 && levelQuan >= 4 && levelGang >= 4 && levelGiay >= 4 && levelNhan >= 4) {
            return 4;
        } else {
            return -1;
        }
    }

    public short getHead() {
        if (effectSkill != null && effectSkill.isMonkey) {
            return (short) ConstPlayer.HEADMONKEY[effectSkill.levelMonkey - 1];
        } else if (effectSkill != null && effectSkill.isSocola) {
            return 412;

        } else if (effectSkill != null && effectSkill.isMaPhongBa) {
            return 412;

        } else if (effectSkill.isBang) {
            return 1251;
        } else if (effectSkill.isDa) {
            return 454;
        } else if (effectSkill.isCarot) {
            return 406;

        } else if (fusion != null && fusion.typeFusion != ConstPlayer.NON_FUSION) {
            // CT Hop The Index 12
            if (this.isPl() && this.pet != null) {
//                Item ctInd12 = inventory.itemsBody.get(12);
                Item ctKamin = inventory.itemsBody.get(5);
                Item ctOren = pet.inventory.itemsBody.get(5);
                if (ctOren.isNotNullItem() && ctKamin.isNotNullItem()
                        && ctOren.isNotNullItem()
                        && (ctKamin.template.id == 1322 || ctKamin.template.id == 1323)
                        && (ctOren.template.id == 1322 || ctOren.template.id == 1323)) {
                    return 1612;
                }
            }
            if (fusion.typeFusion == ConstPlayer.LUONG_LONG_NHAT_THE) {
                return idOutfitFusion[this.gender == ConstPlayer.NAMEC ? 2 : 0][0];
            } else if (fusion.typeFusion == ConstPlayer.HOP_THE_PORATA) {
                if (this.pet.typePet == 1) {
                    return idOutfitFusion[3 + this.gender][0];
                }
                return idOutfitFusion[this.gender == ConstPlayer.NAMEC ? 2 : 1][0];
            } else if (fusion.typeFusion == ConstPlayer.HOP_THE_PORATA2) {
                if (this.pet.typePet == 1) {
                    return idOutfitFusion[3 + this.gender][0];
                }
                return idOutfitFusion[3 + this.gender][0];
            }
        } else if (inventory != null && inventory.itemsBody.get(5).isNotNullItem()) {
            int head = inventory.itemsBody.get(5).template.head;
            if (head != -1) {
                return (short) head;
            }
        }
        return this.head;
    }

    public short getBody() {
        if (effectSkill != null && effectSkill.isMonkey) {
            return 193;
        } else if (effectSkill != null && effectSkill.isSocola) {
            return 413;

        } else if (effectSkill != null && effectSkill.isMaPhongBa) {
            return 1339;
        } else if (effectSkill.isBang) {
            return 1252;
        } else if (effectSkill.isDa) {
            return 455;
        } else if (effectSkill.isCarot) {
            return 407;
        } else if (fusion != null && fusion.typeFusion != ConstPlayer.NON_FUSION) {
            // CT Hop The Index 12
            if (this.isPl() && this.pet != null) {
//                Item ctInd12 = inventory.itemsBody.get(12);
                Item ctKamin = inventory.itemsBody.get(5);
                Item ctOren = pet.inventory.itemsBody.get(5);
                if (ctOren.isNotNullItem() && ctKamin.isNotNullItem()
                        && ctOren.isNotNullItem()
                        && (ctKamin.template.id == 1322 || ctKamin.template.id == 1323)
                        && (ctOren.template.id == 1322 || ctOren.template.id == 1323)) {
                    return 1613;
                }
            }
            if (fusion.typeFusion == ConstPlayer.LUONG_LONG_NHAT_THE) {
                return idOutfitFusion[this.gender == ConstPlayer.NAMEC ? 2 : 0][1];
            } else if (fusion.typeFusion == ConstPlayer.HOP_THE_PORATA) {
                if (this.pet.typePet == 1) {
                    return idOutfitFusion[3 + this.gender][1];
                }
                return idOutfitFusion[this.gender == ConstPlayer.NAMEC ? 2 : 1][1];
            } else if (fusion.typeFusion == ConstPlayer.HOP_THE_PORATA2) {
                if (this.pet.typePet == 1) {
                    return idOutfitFusion[3 + this.gender][1];
                }
                return idOutfitFusion[3 + this.gender][1];
            }
        } else if (inventory != null && inventory.itemsBody.get(5).isNotNullItem()) {
            int body = inventory.itemsBody.get(5).template.body;
            if (body != -1) {
                return (short) body;
            }
        }
        if (inventory != null && inventory.itemsBody.get(0).isNotNullItem()) {
            return inventory.itemsBody.get(0).template.part;
        }
        return (short) (gender == ConstPlayer.NAMEC ? 59 : 57);
    }

    public short getLeg() {
        if (effectSkill != null && effectSkill.isMonkey) {
            return 194;
        } else if (effectSkill != null && effectSkill.isSocola) {
            return 414;
        } else if (effectSkill != null && effectSkill.isMaPhongBa) {
            return 414;
        } else if (effectSkill.isBang) {
            return 1253;
        } else if (effectSkill.isDa) {
            return 456;
        } else if (effectSkill.isCarot) {
            return 408;
        } else if (fusion != null && fusion.typeFusion != ConstPlayer.NON_FUSION) {
            // CT Hop The Index 12
            if (this.isPl() && this.pet != null) {
//                Item ctInd12 = inventory.itemsBody.get(12);
                Item ctKamin = inventory.itemsBody.get(5);
                Item ctOren = pet.inventory.itemsBody.get(5);
                if (ctOren.isNotNullItem() && ctKamin.isNotNullItem()
                        && ctOren.isNotNullItem()
                        && (ctKamin.template.id == 1322 || ctKamin.template.id == 1323)
                        && (ctOren.template.id == 1322 || ctOren.template.id == 1323)) {
                    return 1614;
                }
            }
            if (fusion.typeFusion == ConstPlayer.LUONG_LONG_NHAT_THE) {
                return idOutfitFusion[this.gender == ConstPlayer.NAMEC ? 2 : 0][2];
            } else if (fusion.typeFusion == ConstPlayer.HOP_THE_PORATA) {
                if (this.pet.typePet == 1) {
                    return idOutfitFusion[3 + this.gender][2];
                }
                return idOutfitFusion[this.gender == ConstPlayer.NAMEC ? 2 : 1][2];
            } else if (fusion.typeFusion == ConstPlayer.HOP_THE_PORATA2) {
                if (this.pet.typePet == 1) {
                    return idOutfitFusion[3 + this.gender][2];
                }
                return idOutfitFusion[3 + this.gender][2];
            }
        } else if (inventory != null && inventory.itemsBody.get(5).isNotNullItem()) {
            int leg = inventory.itemsBody.get(5).template.leg;
            if (leg != -1) {
                return (short) leg;
            }
        }
        if (inventory != null && inventory.itemsBody.get(1).isNotNullItem()) {
            return inventory.itemsBody.get(1).template.part;
        }
        return (short) (gender == 1 ? 60 : 58);
    }

    public byte getAura() {
        // So suu tam
        Card card = this.Cards.stream().filter(c -> c.Level >= 2 && c.Used == 1 && c.getCardAuraId() >= 0).findFirst().orElse(null);
        if (card != null) {
            byte auraId = card.getCardAuraId();
            System.out.print(auraId);
            return auraId;
        }

        if (this.inventory.itemsBody.isEmpty() || this.inventory.itemsBody.size() < 13) {
            return -1;
        }
        Item item = this.inventory.itemsBody.get(5);
        if (!item.isNotNullItem()) {
            return 22;
        }
        if (!item.isNotNullItem()) {
            return 58;
        }
        if (this.nPoint.power >= 2000L && this.nPoint.power <= 1300000000000L) {
            return 22;
        } else if (item.template.id == 1128) {
            return 15;
        } else if (item.template.id == 1248) {
            return 22;
        } else if (item.template.id == 1247) {
            return 22;
        } else if (item.template.id == 2092) {
            return 13;
//        } else if (item.template.id == 1282) {
//            return 26;
//        } else if (item.template.id == 1284) {
//            return 25;
//        } else if (item.template.id == 1290) {
//            return 24;
//        }  else if (item.template.id == 1291) {
//            return 23;
//        } else if (item.template.id == 1295) {
//            return 22;
//        } else if (item.template.id == 1296) {
//            return 21;
//        } else if (item.template.id == 1297) {
//            return 20;
//        } else if (item.template.id == 1298) {
//            return 17;
//        } else if (item.template.id == 1300) {
//            return 16;
//        } else if (item.template.id == 1301) {
//            return 15;
//        } else if (item.template.id == 1302) {
//            return 14;
//        } else if (item.template.id == 1306) {
//            return 13;
//        }else if (item.template.id == 1308) {
//            return 12;
//        }else if (item.template.id == 1309) {
//            return 11;
//        }else if (item.template.id == 1310) {
//            return 10;
        } else {
            return -1;
        }

    }

//        public byte getAura_2_0() {
//        if (this.inventory.itemsBody.isEmpty() || this.inventory.itemsBody.size() < 10) {
//            return -1;
//        }
//        Item item = this.inventory.itemsBody.get(5);
//        if (!item.isNotNullItem()) {
//            return -1;
//        }
//        if (item.template.id == 1997) {
//            return 1;
//        } else {
//            return -1;
//        }
//
//    }
    public short getFlagBag() {
        if (this.iDMark.isHoldBlackBall()) {
            return 31;
        } else if (this.idNRNM >= 353 && this.idNRNM <= 359) {
            return 30;
        }
        if (this.inventory.itemsBody.size() == 13) {
            if (this.inventory.itemsBody.get(8).isNotNullItem()) {
                return this.inventory.itemsBody.get(8).template.part;
            }
        }
        if (TaskService.gI().getIdTask(this) == ConstTask.TASK_3_2) {
            return 28;
        }
        if (this.clan != null) {
            return (short) this.clan.imgId;
        }
        return -1;
    }
///
    public Mob mobTarget;

    public long lastTimeTargetMob;

    public long timeTargetMob;

    public long lastTimeAttack;

    public void moveTo(int x, int y) {
        byte dir = (byte) (this.location.x - x < 0 ? 1 : -1);
        byte move = (byte) Util.nextInt(40, 60);
        if (isBot) {
            move = (byte) (move * (byte) 2);
        }
        PlayerService.gI().playerMove(this, this.location.x + (dir == 1 ? move : -move), y + (Util.isTrue(3, 10) ? -50 : 0));
    }

    public Mob getMobAttack() {
        if (this.mobTarget != null && (this.mobTarget.isDie() || !this.zone.equals(this.mobTarget.zone))) {
            this.mobTarget = null;
        }
        if (this.mobTarget == null && Util.canDoWithTime(lastTimeTargetMob, timeTargetMob)) {
            this.mobTarget = this.zone.getRandomMobInMap();
            this.lastTimeTargetMob = System.currentTimeMillis();
            this.timeTargetMob = 500;
        }
        return this.mobTarget;
    }

    public void active() {
        if (this.isBot) {
            if (this.isDie()) {
                this.nPoint.hp = this.nPoint.hpMax;
            }
            if (this.nPoint.mp <= 0) {
                this.nPoint.mp = this.nPoint.mpMax;
            }
            this.attack();
        }
    }

    public int getRangeCanAttackWithSkillSelect() {
        int skillId = this.playerSkill.skillSelect.template.id;
        if (skillId == Skill.KAMEJOKO || skillId == Skill.MASENKO || skillId == Skill.ANTOMIC) {
            return Skill.RANGE_ATTACK_CHIEU_CHUONG;
        } else if (skillId == Skill.DRAGON || skillId == Skill.DEMON || skillId == Skill.GALICK) {
            return Skill.RANGE_ATTACK_CHIEU_DAM;
        }
        return 752002;
    }

    public void attack() {
        if (this.isBot) {
            //this.mobTarget = this.getMobAttack();
            if (Util.canDoWithTime(lastTimeAttack, 100) && this.mobTarget != null) {

                this.lastTimeAttack = System.currentTimeMillis();
                try {
                    Mob m = this.getMobAttack();
                    if (m == null || m.isDie()) {
                        return;
                    }

                    this.playerSkill.skillSelect = this.playerSkill.skills.get(Util.nextInt(0, this.playerSkill.skills.size() - 1));
                    //System.out.println(m.name);
                    if (Util.nextInt(100) < 80) {
                        this.playerSkill.skillSelect = this.playerSkill.skills.get(0);
                    }
                    if (Util.getDistance(this, m) <= this.getRangeCanAttackWithSkillSelect()) {
                        if (Util.isTrue(5, 20)) {
                            if (SkillUtil.isUseSkillChuong(this)) {
                                this.moveTo(m.location.x + (Util.getOne(-1, 1) * Util.nextInt(20, 200)),
                                        Util.nextInt(10) % 2 == 0 ? m.location.y : m.location.y);
                            } else {
                                this.moveTo(m.location.x + (Util.getOne(-1, 1) * Util.nextInt(10, 40)),
                                        Util.nextInt(10) % 2 == 0 ? m.location.y : m.location.y);
                            }
                        }
                        SkillService.gI().useSkill(this, null, m, null);
                    } else {
                        this.moveTo(m.location.x, m.location.y);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                this.mobTarget = getMobAttack();
            }
        }
    }
///

    public short getMount() {
        if (this.inventory.itemsBody.isEmpty() || this.inventory.itemsBody.size() < 13) {
            return -1;
        }
        Item item = this.inventory.itemsBody.get(9);
        if (!item.isNotNullItem()) {
            return -1;
        }
        if (item.template.type == 24) {
            if (item.template.gender == 3 || item.template.gender == this.gender) {
                return item.template.id;
            } else {
                return -1;
            }
        } else {
            if (item.template.id < 500) {
                return item.template.id;
            } else {
                return (short) DataGame.MAP_MOUNT_NUM.get(String.valueOf(item.template.id));
            }
        }

    }

    //--------------------------------------------------------------------------
    public double injured(Player plAtt, double damage, boolean piercing, boolean isMobAttack) {
        if (!this.isDie()) {
            if (plAtt != null) {
                switch (plAtt.playerSkill.skillSelect.template.id) {
                    case Skill.KAMEJOKO:
                    case Skill.MASENKO:
                    case Skill.ANTOMIC:
                        if (this.nPoint.voHieuChuong > 0) {
                            com.girlkun.services.PlayerService.gI().hoiPhuc(this, 0, Util.ndt(damage * this.nPoint.voHieuChuong / 100));
                            return 0;
                        }
                }
            }
            if (!piercing && Util.isTrue(this.nPoint.tlNeDon, 100)) {
                Service.gI().chat(this, "Xí hụt, tỉ lệ né của ta là " + this.nPoint.tlNeDon);
                return 0;
            }
            damage = this.nPoint.subDameInjureWithDeff(damage);
            if (!piercing && effectSkill.isShielding) {
                if (damage > nPoint.hpMax) {
                    EffectSkillService.gI().breakShield(this);
                }
                damage = 1;
            }
            if (this.pet != null && this.pet.status < 3) {
                this.pet.angry(plAtt);
            }
            if (this.isPet && (((Pet) this).status < 3)) {
                ((Pet) this).angry(plAtt);
            }
            if (isMobAttack && this.charms.tdBatTu > System.currentTimeMillis() && damage >= this.nPoint.hp) {
                damage = this.nPoint.hp - 1;
            }

            this.nPoint.subHP(damage);
            if (isDie()) {
                if (this.zone.map.mapId == 112) {
                    plAtt.pointPvp++;
                }
                setDie(plAtt);
            }
            return damage;
        } else {
            return 0;
        }
    }

    protected void setDie(Player plAtt) {
        //xóa phù
        if (this.effectSkin.xHPKI > 1) {
            this.effectSkin.xHPKI = 1;
            Service.gI().point(this);
        }
        //xóa tụ skill đặc biệt
        this.playerSkill.prepareQCKK = false;
        this.playerSkill.prepareLaze = false;
        this.playerSkill.prepareTuSat = false;
        //xóa hiệu ứng skill
        this.effectSkill.removeSkillEffectWhenDie();
        //
        nPoint.setHp(0);
        nPoint.setMp(0);
        //xóa trứng
        if (this.mobMe != null) {
            this.mobMe.mobMeDie();
        }
        Service.gI().charDie(this);
        //add kẻ thù
        if (!this.isPet && !this.isNewPet && !this.isBoss && plAtt != null && !plAtt.isPet && !plAtt.isNewPet && !plAtt.isBoss) {
            if (!plAtt.itemTime.isUseAnDanh) {
                FriendAndEnemyService.gI().addEnemy(this, plAtt);
                if (TaskService.gI().getIdTask(plAtt) == ConstTask.TASK_27_2) {
                    TaskService.gI().checkDoneTaskKillPlayer(plAtt);
                }
            }
        }
        if (this.isPl() && plAtt != null && plAtt.isPl()) {
            plAtt.achievement.plusCount(3);
        }
        //kết thúc pk
        if (this.pvp != null) {
            this.pvp.lose(this, TYPE_LOSE_PVP.DEAD);
        }
//        PVPServcice.gI().finishPVP(this, PVP.TYPE_DIE);
        BlackBallWar.gI().dropBlackBall(this);
    }

    //--------------------------------------------------------------------------
    public void setClanMember() {
        if (this.clanMember != null) {
            this.clanMember.powerPoint = this.nPoint.power;
            this.clanMember.head = this.getHead();
            this.clanMember.body = this.getBody();
            this.clanMember.leg = this.getLeg();
        }
    }

    public boolean isAdmin() {
        return this.session.isAdmin;
    }

    public void setJustRevivaled() {
        this.justRevived = true;
        this.lastTimeRevived = System.currentTimeMillis();
    }

    public void preparedToDispose() {

    }

    public void dispose() {
        if (pet != null) {
            pet.dispose();
            pet = null;
        }
        if (newpet != null) {
            newpet.dispose();
            newpet = null;
        }
        if (mapBlackBall != null) {
            mapBlackBall.clear();
            mapBlackBall = null;
        }
        zone = null;
        mapBeforeCapsule = null;
        //
        if (mapMaBu != null) {
            mapMaBu.clear();
            mapMaBu = null;
        }
        if (billEgg != null) {
            billEgg.dispose();
            billEgg = null;
        }
        zone = null;
        mapBeforeCapsule = null;
        if (mapCapsule != null) {
            mapCapsule.clear();
            mapCapsule = null;
        }
        if (mobMe != null) {
            mobMe.dispose();
            mobMe = null;
        }
        location = null;
        if (setClothes != null) {
            setClothes.dispose();
            setClothes = null;
        }
        if (effectSkill != null) {
            effectSkill.dispose();
            effectSkill = null;
        }
        if (mabuEgg != null) {
            mabuEgg.dispose();
            mabuEgg = null;
        }
        if (skillSpecial != null) {
            skillSpecial.dispose();
            skillSpecial = null;
        }
        if (playerTask != null) {
            playerTask.dispose();
            playerTask = null;
        }
        if (itemTime != null) {
            itemTime.dispose();
            itemTime = null;
        }
        if (fusion != null) {
            fusion.dispose();
            fusion = null;
        }
        if (magicTree != null) {
            magicTree.dispose();
            magicTree = null;
        }
        if (playerIntrinsic != null) {
            playerIntrinsic.dispose();
            playerIntrinsic = null;
        }
        if (inventory != null) {
            inventory.dispose();
            inventory = null;
        }
        if (playerSkill != null) {
            playerSkill.dispose();
            playerSkill = null;
        }
        if (combineNew != null) {
            combineNew.dispose();
            combineNew = null;
        }
        if (iDMark != null) {
            iDMark.dispose();
            iDMark = null;
        }
        if (charms != null) {
            charms.dispose();
            charms = null;
        }

        if (effectSkin != null) {
            effectSkin.dispose();
            effectSkin = null;
        }
        if (nPoint != null) {
            nPoint.dispose();
            nPoint = null;
        }
        if (rewardBlackBall != null) {
            rewardBlackBall.dispose();
            rewardBlackBall = null;
        }
        if (effectFlagBag != null) {
            effectFlagBag.dispose();
            effectFlagBag = null;
        }
        if (pvp != null) {
            pvp.dispose();
            pvp = null;
        }
        effectFlagBag = null;
        clan = null;
        clanMember = null;
        friends = null;
        enemies = null;
        session = null;
        name = null;
    }

    public String percentGold(int type) {
        try {
            if (type == 0) {
                double percent = ((double) this.goldNormar / ChonAiDay.gI().goldNormar) * 100;
                return String.valueOf(Math.ceil(percent));
            } else if (type == 1) {
                double percent = ((double) this.goldVIP / ChonAiDay.gI().goldVip) * 100;
                return String.valueOf(Math.ceil(percent));
            }
        } catch (ArithmeticException e) {
            return "0";
        }
        return "0";
    }

    public List<String> textRuongGo = new ArrayList<>();

    public BoMong achievement;

}
