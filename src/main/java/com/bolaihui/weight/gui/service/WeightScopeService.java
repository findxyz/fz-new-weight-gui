package com.bolaihui.weight.gui.service;

import com.bolaihui.weight.gui.client.ZmdClient;
import com.bolaihui.weight.gui.context.WeightContext;
import com.bolaihui.weight.gui.util.BaseUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class WeightScopeService {

    private static Logger logger = LoggerFactory.getLogger(WeightScopeService.class);

    private static WeightContext weightContext = WeightContext.getInstance();

    public static void getWeightScope() {
        try {
            String weightScope = ZmdClient.weightScope("");
            if (StringUtils.isNotBlank(weightScope)) {
                weightContext.getWeightForm().getWeightScopeValue().setText(weightScope);
            }
        } catch (Exception e) {
            String error = BaseUtil.getExceptionStackTrace(e);
            logger.error(error);
            BaseUtil.textAreaErrorDialog("错误", error);
        }
    }

    public static void setWeightScope() {
        try {
            String weightScope = weightContext.getWeightForm().getWeightScopeValue().getText();
            String backWeightScope = ZmdClient.weightScope(weightScope);
            if (StringUtils.isNotBlank(backWeightScope)) {
                BaseUtil.messageDialog("设置成功");
            } else {
                BaseUtil.messageDialog("设置失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(BaseUtil.getExceptionStackTrace(e));
        }
    }
}
