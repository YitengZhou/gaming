package com.zhouyiteng.gambling.controller.game;

import com.zhouyiteng.gambling.controller.BaseController;
import com.zhouyiteng.gambling.model.game.BetRaceModel;
import com.zhouyiteng.gambling.model.game.FastCarModel;
import com.zhouyiteng.gambling.model.game.GenerateType;
import com.zhouyiteng.gambling.model.web.PageDataModel;
import com.zhouyiteng.gambling.service.game.FastCarService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 急速快车相关操作的控制器
 *
 * @author bake@eastmoney.com
 *
 * Created by liubake on 2021/02/07.
 */
@Slf4j
@RestController
@RequestMapping("/game/fastcar")
public class FastCarController extends BaseController {

    @Autowired
    FastCarService fastCarService;

    /**
     * 手动添加随机生成的结果
     * @return
     */
    @PostMapping("/test-create")
    public boolean testCreate(){
        return fastCarService.createNewRace(GenerateType.MANUAL);
    }

    /**
     * 获得极速赛车比赛结果
     * @return
     */
    @GetMapping("get-fastcar-list")
    public PageDataModel<FastCarModel> getFastCarList(@RequestParam(required = false) Long pageSize,
                                                      @RequestParam(required = false) Long pageIndex){
        return fastCarService.getFastCarList(pageSize, pageIndex);
    }

    /**
     * 添加投注
     */
    @PostMapping("addBetRace")
    public Double addBetRace(@RequestBody BetRaceModel betRaceModel){
        if (StringUtils.isEmpty(betRaceModel.getRaceId())){
            throw new IllegalArgumentException("比赛场次标识不能为空");
        }
        if (StringUtils.isEmpty(betRaceModel.getUserId())){
            throw new IllegalArgumentException("比赛场次标识不能为空");
        }
        if (betRaceModel.getTotalMoney()<0){
            throw new IllegalArgumentException("投注金额不能为负");
        }
        return fastCarService.addBetRace(betRaceModel);
    }
}
