package com.siwei.worldCreator;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenerateSources extends Thread {
	private Log log;
	private SourceMapper sourceMapper;

	public GenerateSources() {
		log = LogFactory.getLog(GenerateSources.class);
	}

	private void checkAndAddSources(Sources sources) {
		if (sources.getS1() > 100) {
			sources.setS1(sources.getS1() + 1);
		}

		if (sources.getS2() > 100) {
			sources.setS2(sources.getS2() + 1);
		}
		if (sources.getS3() > 100) {
			sources.setS3(sources.getS3() + 1);
		}
		if (sources.getS4() > 100) {
			sources.setS4(sources.getS4() + 1);
		}
		if (sources.getS5() > 100) {
			sources.setS5(sources.getS5() + 1);
		}
		if (sources.getS6() > 100) {
			sources.setS6(sources.getS6() + 1);
		}
		if (sources.getS7() > 100) {
			sources.setS7(sources.getS7() + 1);
		}
		if (sources.getS8() > 100) {
			sources.setS8(sources.getS8() + 1);
		}
		if (sources.getS9() > 100) {
			sources.setS9(sources.getS9() + 1);
		}
		if (sources.getS10() > 100) {
			sources.setS10(sources.getS10() + 1);
		}
		if (sources.getS11() > 100) {
			sources.setS11(sources.getS11() + 1);
		}
		if (sources.getS12() > 100) {
			sources.setS12(sources.getS12() + 1);
		}
		if (sources.getS13() > 100) {
			sources.setS13(sources.getS13() + 1);
		}
		if (sources.getS14() > 100) {
			sources.setS14(sources.getS14() + 1);
		}
		if (sources.getS15() > 100) {
			sources.setS15(sources.getS15() + 1);
		}
		if (sources.getS16() > 100) {
			sources.setS16(sources.getS16() + 1);
		}
		if (sources.getS17() > 100) {
			sources.setS17(sources.getS17() + 1);
		}
		if (sources.getS18() > 100) {
			sources.setS18(sources.getS18() + 1);
		}
		if (sources.getS19() > 100) {
			sources.setS19(sources.getS19() + 1);
		}
		if (sources.getS20() > 100) {
			sources.setS20(sources.getS20() + 1);
		}
		if (sources.getS21() > 100) {
			sources.setS21(sources.getS21() + 1);
		}
		if (sources.getS22() > 100) {
			sources.setS22(sources.getS22() + 1);
		}
		if (sources.getS23() > 100) {
			sources.setS23(sources.getS23() + 1);
		}
		if (sources.getS24() > 100) {
			sources.setS24(sources.getS24() + 1);
		}
		if (sources.getS25() > 100) {
			sources.setS25(sources.getS25() + 1);
		}
		if (sources.getS26() > 100) {
			sources.setS26(sources.getS26() + 1);
		}
		if (sources.getS27() > 100) {
			sources.setS27(sources.getS27() + 1);
		}
		if (sources.getS28() > 100) {
			sources.setS28(sources.getS28() + 1);
		}
		if (sources.getS29() > 100) {
			sources.setS29(sources.getS29() + 1);
		}
		if (sources.getS30() > 100) {
			sources.setS30(sources.getS30() + 1);
		}
		if (sources.getS31() > 100) {
			sources.setS31(sources.getS31() + 1);
		}
		if (sources.getS32() > 100) {
			sources.setS32(sources.getS32() + 1);
		}
		if (sources.getS33() > 100) {
			sources.setS33(sources.getS33() + 1);
		}
		if (sources.getS34() > 100) {
			sources.setS34(sources.getS34() + 1);
		}
		if (sources.getS35() > 100) {
			sources.setS35(sources.getS35() + 1);
		}
		if (sources.getS36() > 100) {
			sources.setS36(sources.getS36() + 1);
		}
		if (sources.getS37() > 100) {
			sources.setS37(sources.getS37() + 1);
		}
		if (sources.getS38() > 100) {
			sources.setS38(sources.getS38() + 1);
		}
		if (sources.getS39() > 100) {
			sources.setS39(sources.getS39() + 1);
		}
		if (sources.getS40() > 100) {
			sources.setS40(sources.getS40() + 1);
		}
		if (sources.getS41() > 100) {
			sources.setS41(sources.getS41() + 1);
		}
		if (sources.getS42() > 100) {
			sources.setS42(sources.getS42() + 1);
		}
		if (sources.getS43() > 100) {
			sources.setS43(sources.getS43() + 1);
		}
		if (sources.getS44() > 100) {
			sources.setS44(sources.getS44() + 1);
		}
		if (sources.getS45() > 100) {
			sources.setS45(sources.getS45() + 1);
		}
		if (sources.getS46() > 100) {
			sources.setS46(sources.getS46() + 1);
		}
		if (sources.getS47() > 100) {
			sources.setS47(sources.getS47() + 1);
		}
		if (sources.getS48() > 100) {
			sources.setS48(sources.getS48() + 1);
		}
		if (sources.getS49() > 100) {
			sources.setS49(sources.getS49() + 1);
		}
		if (sources.getS50() > 100) {
			sources.setS50(sources.getS50() + 1);
		}
	}

	private void updateSources() {
		SessionSql sessionSql = new SessionSql();
		sourceMapper = sessionSql.getSession().getMapper(SourceMapper.class);
		List<Sources> sources = sourceMapper.selectAllSources();
		log.warn("sources size is "+ sources.size());
		for (int i = 0; i < sources.size(); i++) {
			checkAndAddSources(sources.get(i));
			sourceMapper.updateSources(sources.get(i));
		}
		sessionSql.getSession().commit();
		sessionSql.getSession().close();
	}

	@Override
	public void run() {
		System.out.println("GenerateSources.run()");
		this.setName("GenerateSources");
		while (true) {
			try {
				Thread.sleep(1000);
				updateSources();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
