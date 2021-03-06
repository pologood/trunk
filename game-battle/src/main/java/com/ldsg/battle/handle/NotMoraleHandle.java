package com.ldsg.battle.handle;

import org.apache.log4j.Logger;

import com.ldsg.battle.Context;
import com.ldsg.battle.bo.Buff;
import com.ldsg.battle.bo.Effect;
import com.ldsg.battle.engine.BaseHandle;
import com.ldsg.battle.helper.BuffHelper;
import com.ldsg.battle.role.Hero;

public class NotMoraleHandle extends BaseHandle {

	private static Logger logger = Logger.getLogger(NotMoraleHandle.class);

	public Buff create(Effect effect, Hero hero, Hero target, Context context, int critValue) {
		Buff buff = BuffHelper.Effect2Buff(effect);
		return buff;
	}

	public void handle(Hero hero, Buff buff, Context context) {
		logger.debug("处理打人不产生士气buff.name[" + hero.getLogName() + "]");
		hero.setNotMorale(true);
	}

	public void handleRemove(Hero hero, Buff buff) {
		logger.debug("清除打人不产生士气状态.hero.Name[" + hero.getLogName() + "], effect.Remark[" + buff.getEffect().getRemark() + "]");
		hero.setNotMorale(false);
	}

}
