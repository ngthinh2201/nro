package com.girlkun.models.boss.list_boss.tieudoisatthu;

import com.girlkun.models.boss.Boss;
import com.girlkun.models.boss.BossID;
import com.girlkun.models.boss.BossManager;
import com.girlkun.models.boss.BossStatus;
import com.girlkun.models.boss.BossesData;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.server.ServerNotify;
import com.girlkun.services.Service;
import com.girlkun.services.TaskService;
import com.girlkun.services.func.ChangeMapService;
import com.girlkun.utils.Util;
import java.util.Random;

public class So4 extends Boss {

    public So4() throws Exception {
        super(BossID.SO_4, BossesData.SO_4);
    }

    @Override
    public void moveTo(int x, int y) {
        if (this.currentLevel == 1) {
            return;
        }
        super.moveTo(x, y);
    }

    @Override
    public void reward(Player plKill) {
        if (Util.isTrue(15, 100)) {
            ItemMap it = new ItemMap(this.zone, 16, 1, this.location.x, this.zone.map.yPhysicInTop(this.location.x,
                    this.location.y - 24), plKill.id);
            Service.gI().dropItemMap(this.zone, it);
        }
        TaskService.gI().checkDoneTaskKillBoss(plKill, this);
    }

    @Override
    protected void notifyJoinMap() {
        if (this.currentLevel == 1) {
            return;
        }
        super.notifyJoinMap();
    }

    @Override
    public void active() {
        super.active(); //To change body of generated methods, choose Tools | Templates.
        this.SendLaiThongBao(7);
    }

//@Override
//public void joinMap() {
//    if (this.zone == null) {
//        this.zone = getMapCanJoin(mapJoin[Util.nextInt(0, mapJoin.length - 1)]);
//    }
//    if (this.zone != null) {
//        Boss bossSO4 = BossManager.gI().getBossById(BossID.SO_4);
//        Boss bossSO3 = BossManager.gI().getBossById(BossID.SO_3);
//        Boss bossSO2 = BossManager.gI().getBossById(BossID.SO_2);
//        Boss bossSO1 = BossManager.gI().getBossById(BossID.SO_1);
//
//        // Kiểm tra xem tất cả các boss đã xuất hiện chưa
//        if (bossSO4 != null && bossSO3 != null && bossSO2 != null && bossSO1 != null) {
//            ChangeMapService.gI().changeMapBySpaceShip(this, this.zone, ChangeMapService.TENNIS_SPACE_SHIP);
//            ServerNotify.gI().notify("Boss " + this.name + " vừa xuất hiện tại " + this.zone.map.mapName);
//        }
//    }
//}
//
//@Override
//public void leaveMap() {
//    Boss bossSO3 = BossManager.gI().getBossById(BossID.SO_3);
//    if (bossSO3 != null) {
//        bossSO3.changeToAttack();
//    }
//    super.leaveMap();
//    BossManager.gI().removeBoss(this);
//}

}
/**
 * Vui lòng không sao chép mã nguồn này dưới mọi hình thức. Hãy tôn trọng tác
 * giả của mã nguồn này. Xin cảm ơn! - GirlBeo
 */
