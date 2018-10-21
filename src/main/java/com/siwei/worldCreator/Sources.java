package com.siwei.worldCreator;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Sources {
	Log log;

	public Sources() {
		log = LogFactory.getLog(Sources.class);
	};

	public void generateSourcesByRand(int products) {
		for (int i = 1; i <= products; i++) {
			Random random = new Random();
			int p = random.nextInt(50) + 1;
			switch (p) {
			case 1:
				s1 = random.nextInt(10000) + 1;
				break;
			case 2:
				s2 = random.nextInt(10000) + 1;
				break;
			case 3:
				s3 = random.nextInt(10000) + 1;
				break;
			case 4:
				s4 = random.nextInt(10000) + 1;
				break;
			case 5:
				s5 = random.nextInt(10000) + 1;
				break;
			case 6:
				s6 = random.nextInt(10000) + 1;
				break;
			case 7:
				s7 = random.nextInt(10000) + 1;
				break;
			case 8:
				s8 = random.nextInt(10000) + 1;
				break;
			case 9:
				s9 = random.nextInt(10000) + 1;
				break;
			case 10:
				s10 = random.nextInt(10000) + 1;
				break;
			case 11:
				s11 = random.nextInt(10000) + 1;
				break;
			case 12:
				s12 = random.nextInt(10000) + 1;
				break;
			case 13:
				s13 = random.nextInt(10000) + 1;
				break;
			case 14:
				s14 = random.nextInt(10000) + 1;
				break;
			case 15:
				s15 = random.nextInt(10000) + 1;
				break;
			case 16:
				s16 = random.nextInt(10000) + 1;
				break;
			case 17:
				s17 = random.nextInt(10000) + 1;
				break;
			case 18:
				s18 = random.nextInt(10000) + 1;
				break;
			case 19:
				s19 = random.nextInt(10000) + 1;
				break;
			case 20:
				s20 = random.nextInt(10000) + 1;
				break;
			case 21:
				s21 = random.nextInt(10000) + 1;
				break;
			case 22:
				s22 = random.nextInt(10000) + 1;
				break;
			case 23:
				s23 = random.nextInt(10000) + 1;
				break;
			case 24:
				s24 = random.nextInt(10000) + 1;
				break;
			case 25:
				s25 = random.nextInt(10000) + 1;
				break;
			case 26:
				s26 = random.nextInt(10000) + 1;
				break;
			case 27:
				s27 = random.nextInt(10000) + 1;
				break;
			case 28:
				s28 = random.nextInt(10000) + 1;
				break;
			case 29:
				s29 = random.nextInt(10000) + 1;
				break;
			case 30:
				s30 = random.nextInt(10000) + 1;
				break;
			case 31:
				s31 = random.nextInt(10000) + 1;
				break;
			case 32:
				s32 = random.nextInt(10000) + 1;
				break;
			case 33:
				s33 = random.nextInt(10000) + 1;
				break;
			case 34:
				s34 = random.nextInt(10000) + 1;
				break;
			case 35:
				s35 = random.nextInt(10000) + 1;
				break;
			case 36:
				s36 = random.nextInt(10000) + 1;
				break;
			case 37:
				s37 = random.nextInt(10000) + 1;
				break;
			case 38:
				s38 = random.nextInt(10000) + 1;
				break;
			case 39:
				s39 = random.nextInt(10000) + 1;
				break;
			case 40:
				s40 = random.nextInt(10000) + 1;
				break;
			case 41:
				s41 = random.nextInt(10000) + 1;
				break;
			case 42:
				s42 = random.nextInt(10000) + 1;
				break;
			case 43:
				s43 = random.nextInt(10000) + 1;
				break;
			case 44:
				s44 = random.nextInt(10000) + 1;
				break;
			case 45:
				s45 = random.nextInt(10000) + 1;
				break;
			case 46:
				s46 = random.nextInt(10000) + 1;
				break;
			case 47:
				s47 = random.nextInt(10000) + 1;
				break;
			case 48:
				s48 = random.nextInt(10000) + 1;
				break;
			case 49:
				s49 = random.nextInt(10000) + 1;
				break;
			case 50:
				s50 = random.nextInt(10000) + 1;
				break;
			default:
				log.warn("error p p is " + p);
				break;
			}
		}
	}

	public int getS2() {
		return s2;
	}

	public void setS2(int s2) {
		this.s2 = s2;
	}

	private int id;
	private int s1;
	private int s2;
	private int s3;
	private int s4;
	private int s5;
	private int s6;
	private int s7;
	private int s8;
	private int s9;
	private int s10;
	private int s11;
	private int s12;
	private int s13;
	private int s14;
	private int s15;
	private int s16;
	private int s17;
	private int s18;
	private int s19;
	private int s20;
	private int s21;
	private int s22;
	private int s23;
	private int s24;
	private int s25;
	private int s26;
	private int s27;
	private int s28;
	private int s29;
	private int s30;
	private int s31;
	private int s32;
	private int s33;
	private int s34;
	private int s35;
	private int s36;
	private int s37;
	private int s38;
	private int s39;
	private int s40;
	private int s41;
	private int s42;
	private int s43;
	private int s44;
	private int s45;
	private int s46;
	private int s47;
	private int s48;
	private int s49;
	private int s50;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getS1() {
		return s1;
	}

	public void setS1(int s1) {
		this.s1 = s1;
	}

	public int getS3() {
		return s3;
	}

	public void setS3(int s3) {
		this.s3 = s3;
	}

	public int getS4() {
		return s4;
	}

	public void setS4(int s4) {
		this.s4 = s4;
	}

	public int getS5() {
		return s5;
	}

	public void setS5(int s5) {
		this.s5 = s5;
	}

	public int getS6() {
		return s6;
	}

	public void setS6(int s6) {
		this.s6 = s6;
	}

	public int getS7() {
		return s7;
	}

	public void setS7(int s7) {
		this.s7 = s7;
	}

	public int getS8() {
		return s8;
	}

	public void setS8(int s8) {
		this.s8 = s8;
	}

	public int getS9() {
		return s9;
	}

	public void setS9(int s9) {
		this.s9 = s9;
	}

	public int getS10() {
		return s10;
	}

	public void setS10(int s10) {
		this.s10 = s10;
	}

	public int getS11() {
		return s11;
	}

	public void setS11(int s11) {
		this.s11 = s11;
	}

	public int getS12() {
		return s12;
	}

	public void setS12(int s12) {
		this.s12 = s12;
	}

	public int getS13() {
		return s13;
	}

	public void setS13(int s13) {
		this.s13 = s13;
	}

	public int getS14() {
		return s14;
	}

	public void setS14(int s14) {
		this.s14 = s14;
	}

	public int getS15() {
		return s15;
	}

	public void setS15(int s15) {
		this.s15 = s15;
	}

	public int getS16() {
		return s16;
	}

	public void setS16(int s16) {
		this.s16 = s16;
	}

	public int getS17() {
		return s17;
	}

	public void setS17(int s17) {
		this.s17 = s17;
	}

	public int getS18() {
		return s18;
	}

	public void setS18(int s18) {
		this.s18 = s18;
	}

	public int getS19() {
		return s19;
	}

	public void setS19(int s19) {
		this.s19 = s19;
	}

	public int getS20() {
		return s20;
	}

	public void setS20(int s20) {
		this.s20 = s20;
	}

	public int getS21() {
		return s21;
	}

	public void setS21(int s21) {
		this.s21 = s21;
	}

	public int getS22() {
		return s22;
	}

	public void setS22(int s22) {
		this.s22 = s22;
	}

	public int getS23() {
		return s23;
	}

	public void setS23(int s23) {
		this.s23 = s23;
	}

	public int getS24() {
		return s24;
	}

	public void setS24(int s24) {
		this.s24 = s24;
	}

	public int getS25() {
		return s25;
	}

	public void setS25(int s25) {
		this.s25 = s25;
	}

	public int getS26() {
		return s26;
	}

	public void setS26(int s26) {
		this.s26 = s26;
	}

	public int getS27() {
		return s27;
	}

	public void setS27(int s27) {
		this.s27 = s27;
	}

	public int getS28() {
		return s28;
	}

	public void setS28(int s28) {
		this.s28 = s28;
	}

	public int getS29() {
		return s29;
	}

	public void setS29(int s29) {
		this.s29 = s29;
	}

	public int getS30() {
		return s30;
	}

	public void setS30(int s30) {
		this.s30 = s30;
	}

	public int getS31() {
		return s31;
	}

	public void setS31(int s31) {
		this.s31 = s31;
	}

	public int getS32() {
		return s32;
	}

	public void setS32(int s32) {
		this.s32 = s32;
	}

	public int getS33() {
		return s33;
	}

	public void setS33(int s33) {
		this.s33 = s33;
	}

	public int getS34() {
		return s34;
	}

	public void setS34(int s34) {
		this.s34 = s34;
	}

	public int getS35() {
		return s35;
	}

	public void setS35(int s35) {
		this.s35 = s35;
	}

	public int getS36() {
		return s36;
	}

	public void setS36(int s36) {
		this.s36 = s36;
	}

	public int getS37() {
		return s37;
	}

	public void setS37(int s37) {
		this.s37 = s37;
	}

	public int getS38() {
		return s38;
	}

	public void setS38(int s38) {
		this.s38 = s38;
	}

	public int getS39() {
		return s39;
	}

	public void setS39(int s39) {
		this.s39 = s39;
	}

	public int getS40() {
		return s40;
	}

	public void setS40(int s40) {
		this.s40 = s40;
	}

	public int getS41() {
		return s41;
	}

	public void setS41(int s41) {
		this.s41 = s41;
	}

	public int getS42() {
		return s42;
	}

	public void setS42(int s42) {
		this.s42 = s42;
	}

	public int getS43() {
		return s43;
	}

	public void setS43(int s43) {
		this.s43 = s43;
	}

	public int getS44() {
		return s44;
	}

	public void setS44(int s44) {
		this.s44 = s44;
	}

	public int getS45() {
		return s45;
	}

	public void setS45(int s45) {
		this.s45 = s45;
	}

	public int getS46() {
		return s46;
	}

	public void setS46(int s46) {
		this.s46 = s46;
	}

	public int getS47() {
		return s47;
	}

	public void setS47(int s47) {
		this.s47 = s47;
	}

	public int getS48() {
		return s48;
	}

	public void setS48(int s48) {
		this.s48 = s48;
	}

	public int getS49() {
		return s49;
	}

	public void setS49(int s49) {
		this.s49 = s49;
	}

	public int getS50() {
		return s50;
	}

	public void setS50(int s50) {
		this.s50 = s50;
	}

}
