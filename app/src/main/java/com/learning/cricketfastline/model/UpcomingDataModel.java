package com.learning.cricketfastline.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.io.Serializable;

public class UpcomingDataModel extends JSONObject implements Serializable, Parcelable {


    @SerializedName("adBk")
    @Expose
    private String adBk;
    @SerializedName("addInfo")
    @Expose
    private String addInfo;
    @SerializedName("atOddsHist")
    @Expose
    private Boolean atOddsHist;
    @SerializedName("blRem")
    @Expose
    private String blRem;
    @SerializedName("btsM1")
    @Expose
    private String btsM1;
    @SerializedName("btsM1Bls")
    @Expose
    private String btsM1Bls;
    @SerializedName("btsM1Rn")
    @Expose
    private String btsM1Rn;
    @SerializedName("btsM2")
    @Expose
    private String btsM2;
    @SerializedName("btsM2Bls")
    @Expose
    private String btsM2Bls;
    @SerializedName("btsM2Rn")
    @Expose
    private String btsM2Rn;
    @SerializedName("btsMStrk")
    @Expose
    private String btsMStrk;
    @SerializedName("bwl")
    @Expose
    private String bwl;
    @SerializedName("bwlOvr")
    @Expose
    private String bwlOvr;
    @SerializedName("bwlRn")
    @Expose
    private String bwlRn;
    @SerializedName("bwlWkt")
    @Expose
    private String bwlWkt;
    @SerializedName("contest_url")
    @Expose
    private String contestUrl;
    @SerializedName("cricURL")
    @Expose
    private String cricURL;
    @SerializedName("curRnRt")
    @Expose
    private String curRnRt;
    @SerializedName("curScMsg")
    @Expose
    private String curScMsg;
    @SerializedName("fancyInfo")
    @Expose
    private String fancyInfo;
    @SerializedName("favTm")
    @Expose
    private String favTm;
    @SerializedName("fl1")
    @Expose
    private Boolean fl1;
    @SerializedName("fl2")
    @Expose
    private Boolean fl2;
    @SerializedName("fullScorecard")
    @Expose
    private String fullScorecard;
    @SerializedName("fwd1")
    @Expose
    private String fwd1;
    @SerializedName("fwd2")
    @Expose
    private String fwd2;
    @SerializedName("fwdLmbOvr1")
    @Expose
    private String fwdLmbOvr1;
    @SerializedName("fwdLmbOvr2")
    @Expose
    private String fwdLmbOvr2;
    @SerializedName("gNm")
    @Expose
    private String gNm;
    @SerializedName("googleAdBk")
    @Expose
    private String googleAdBk;
    @SerializedName("hsFlScBd")
    @Expose
    private Boolean hsFlScBd;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("ing")
    @Expose
    private String ing;
    @SerializedName("isCompleted")
    @Expose
    private Boolean isCompleted;
    @SerializedName("isFancyInfo")
    @Expose
    private Boolean isFancyInfo;
    @SerializedName("isMatchComplete")
    @Expose
    private Boolean isMatchComplete;
    @SerializedName("isMatchOdds")
    @Expose
    private Boolean isMatchOdds;
    @SerializedName("isMatchTied")
    @Expose
    private Boolean isMatchTied;
    @SerializedName("isTied")
    @Expose
    private Boolean isTied;
    @SerializedName("is_contest_enable")
    @Expose
    private Boolean isContestEnable;
    @SerializedName("is_rain")
    @Expose
    private Boolean isRain;
    @SerializedName("is_showTips")
    @Expose
    private Boolean isShowTips;
    @SerializedName("lmb1")
    @Expose
    private Integer lmb1;
    @SerializedName("lmb2")
    @Expose
    private Integer lmb2;
    @SerializedName("lst6Bl")
    @Expose
    private String lst6Bl;
    @SerializedName("lstWkt")
    @Expose
    private String lstWkt;
    @SerializedName("mCurSts")
    @Expose
    private String mCurSts;
    @SerializedName("mDt")
    @Expose
    private String mDt;
    @SerializedName("mDy")
    @Expose
    private String mDy;
    @SerializedName("mNo")
    @Expose
    private String mNo;
    @SerializedName("mSts")
    @Expose
    private String mSts;
    @SerializedName("mTips")
    @Expose
    private String mTips;
    @SerializedName("mTipsHist")
    @Expose
    private String mTipsHist;
    @SerializedName("mTm")
    @Expose
    private String mTm;
    @SerializedName("matchEndDateTime")
    @Expose
    private String matchEndDateTime;
    @SerializedName("matchStartDateTime")
    @Expose
    private String matchStartDateTime;
    @SerializedName("mcYesNo")
    @Expose
    private String mcYesNo;
    @SerializedName("mtYesNo")
    @Expose
    private String mtYesNo;
    @SerializedName("nt1")
    @Expose
    private String nt1;
    @SerializedName("nt2")
    @Expose
    private String nt2;
    @SerializedName("nt3")
    @Expose
    private String nt3;
    @SerializedName("nt4")
    @Expose
    private String nt4;
    @SerializedName("nt5")
    @Expose
    private String nt5;
    @SerializedName("nt6")
    @Expose
    private String nt6;
    @SerializedName("oddDiff")
    @Expose
    private String oddDiff;
    @SerializedName("oddDiffMC")
    @Expose
    private String oddDiffMC;
    @SerializedName("oddDiffMT")
    @Expose
    private String oddDiffMT;
    @SerializedName("oddsHistId")
    @Expose
    private String oddsHistId;
    @SerializedName("oddsHistId1")
    @Expose
    private String oddsHistId1;
    @SerializedName("onBt")
    @Expose
    private String onBt;
    @SerializedName("pAdBk")
    @Expose
    private String pAdBk;
    @SerializedName("pTvAdBk")
    @Expose
    private String pTvAdBk;
    @SerializedName("rnNd")
    @Expose
    private String rnNd;
    @SerializedName("rqRnRt")
    @Expose
    private String rqRnRt;
    @SerializedName("sNm")
    @Expose
    private String sNm;
    @SerializedName("sessionInfo")
    @Expose
    private String sessionInfo;
    @SerializedName("sessionKey")
    @Expose
    private String sessionKey;
    @SerializedName("showScroller")
    @Expose
    private Boolean showScroller;
    @SerializedName("shwTps")
    @Expose
    private Boolean shwTps;
    @SerializedName("ss1")
    @Expose
    private Boolean ss1;
    @SerializedName("ss2")
    @Expose
    private Boolean ss2;
    @SerializedName("ss3")
    @Expose
    private Boolean ss3;
    @SerializedName("ss4")
    @Expose
    private Boolean ss4;
    @SerializedName("ss5")
    @Expose
    private Boolean ss5;
    @SerializedName("ss6")
    @Expose
    private Boolean ss6;
    @SerializedName("ssOvr1")
    @Expose
    private String ssOvr1;
    @SerializedName("ssOvr2")
    @Expose
    private String ssOvr2;
    @SerializedName("ssOvr3")
    @Expose
    private String ssOvr3;
    @SerializedName("ssOvr4")
    @Expose
    private String ssOvr4;
    @SerializedName("ssOvr5")
    @Expose
    private String ssOvr5;
    @SerializedName("ssOvr6")
    @Expose
    private String ssOvr6;
    @SerializedName("ssSpd1")
    @Expose
    private Boolean ssSpd1;
    @SerializedName("ssSpd2")
    @Expose
    private Boolean ssSpd2;
    @SerializedName("ssSpd3")
    @Expose
    private Boolean ssSpd3;
    @SerializedName("ssSpd4")
    @Expose
    private Boolean ssSpd4;
    @SerializedName("ssSpd5")
    @Expose
    private Boolean ssSpd5;
    @SerializedName("ssSpd6")
    @Expose
    private Boolean ssSpd6;
    @SerializedName("t1")
    @Expose
    private String t1;
    @SerializedName("t1Back")
    @Expose
    private String t1Back;
    @SerializedName("t1BackMC")
    @Expose
    private String t1BackMC;
    @SerializedName("t1BackMT")
    @Expose
    private String t1BackMT;
    @SerializedName("t1CurOvr")
    @Expose
    private String t1CurOvr;
    @SerializedName("t1Lay")
    @Expose
    private String t1Lay;
    @SerializedName("t1LayMC")
    @Expose
    private String t1LayMC;
    @SerializedName("t1LayMT")
    @Expose
    private String t1LayMT;
    @SerializedName("t1Rn")
    @Expose
    private String t1Rn;
    @SerializedName("t1TotOvr")
    @Expose
    private String t1TotOvr;
    @SerializedName("t1Wkt")
    @Expose
    private String t1Wkt;
    @SerializedName("t1XI")
    @Expose
    private String t1XI;
    @SerializedName("t1_short")
    @Expose
    private String t1Short;
    @SerializedName("t2")
    @Expose
    private String t2;
    @SerializedName("t2Back")
    @Expose
    private String t2Back;
    @SerializedName("t2BackMC")
    @Expose
    private String t2BackMC;
    @SerializedName("t2BackMT")
    @Expose
    private String t2BackMT;
    @SerializedName("t2CurOvr")
    @Expose
    private String t2CurOvr;
    @SerializedName("t2Lay")
    @Expose
    private String t2Lay;
    @SerializedName("t2LayMC")
    @Expose
    private String t2LayMC;
    @SerializedName("t2LayMT")
    @Expose
    private String t2LayMT;
    @SerializedName("t2Rn")
    @Expose
    private String t2Rn;
    @SerializedName("t2TotOvr")
    @Expose
    private String t2TotOvr;
    @SerializedName("t2Wkt")
    @Expose
    private String t2Wkt;
    @SerializedName("t2XI")
    @Expose
    private String t2XI;
    @SerializedName("t2_short")
    @Expose
    private String t2Short;
    @SerializedName("trgt")
    @Expose
    private String trgt;
    @SerializedName("tvPrivateAdBk")
    @Expose
    private String tvPrivateAdBk;
    @SerializedName("updatedFancyInfo")
    @Expose
    private String updatedFancyInfo;
    @SerializedName("wethr")
    @Expose
    private String wethr;
    @SerializedName("yes1")
    @Expose
    private Integer yes1;
    @SerializedName("yes2")
    @Expose
    private Integer yes2;
    @SerializedName("yes3")
    @Expose
    private Integer yes3;
    @SerializedName("yes4")
    @Expose
    private Integer yes4;
    @SerializedName("yes5")
    @Expose
    private Integer yes5;
    @SerializedName("yes6")
    @Expose
    private Integer yes6;
    private String matchid;

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid;
    }

    public UpcomingDataModel() {
    }

    protected UpcomingDataModel(Parcel in) {
        adBk = in.readString();
        addInfo = in.readString();
        byte tmpAtOddsHist = in.readByte();
        atOddsHist = tmpAtOddsHist == 0 ? null : tmpAtOddsHist == 1;
        blRem = in.readString();
        btsM1 = in.readString();
        btsM1Bls = in.readString();
        btsM1Rn = in.readString();
        btsM2 = in.readString();
        btsM2Bls = in.readString();
        btsM2Rn = in.readString();
        btsMStrk = in.readString();
        bwl = in.readString();
        bwlOvr = in.readString();
        bwlRn = in.readString();
        bwlWkt = in.readString();
        contestUrl = in.readString();
        cricURL = in.readString();
        curRnRt = in.readString();
        curScMsg = in.readString();
        fancyInfo = in.readString();
        favTm = in.readString();
        byte tmpFl1 = in.readByte();
        fl1 = tmpFl1 == 0 ? null : tmpFl1 == 1;
        byte tmpFl2 = in.readByte();
        fl2 = tmpFl2 == 0 ? null : tmpFl2 == 1;
        fullScorecard = in.readString();
        fwd1 = in.readString();
        fwd2 = in.readString();
        fwdLmbOvr1 = in.readString();
        fwdLmbOvr2 = in.readString();
        gNm = in.readString();
        googleAdBk = in.readString();
        byte tmpHsFlScBd = in.readByte();
        hsFlScBd = tmpHsFlScBd == 0 ? null : tmpHsFlScBd == 1;
        info = in.readString();
        ing = in.readString();
        byte tmpIsCompleted = in.readByte();
        isCompleted = tmpIsCompleted == 0 ? null : tmpIsCompleted == 1;
        byte tmpIsFancyInfo = in.readByte();
        isFancyInfo = tmpIsFancyInfo == 0 ? null : tmpIsFancyInfo == 1;
        byte tmpIsMatchComplete = in.readByte();
        isMatchComplete = tmpIsMatchComplete == 0 ? null : tmpIsMatchComplete == 1;
        byte tmpIsMatchOdds = in.readByte();
        isMatchOdds = tmpIsMatchOdds == 0 ? null : tmpIsMatchOdds == 1;
        byte tmpIsMatchTied = in.readByte();
        isMatchTied = tmpIsMatchTied == 0 ? null : tmpIsMatchTied == 1;
        byte tmpIsTied = in.readByte();
        isTied = tmpIsTied == 0 ? null : tmpIsTied == 1;
        byte tmpIsContestEnable = in.readByte();
        isContestEnable = tmpIsContestEnable == 0 ? null : tmpIsContestEnable == 1;
        byte tmpIsRain = in.readByte();
        isRain = tmpIsRain == 0 ? null : tmpIsRain == 1;
        byte tmpIsShowTips = in.readByte();
        isShowTips = tmpIsShowTips == 0 ? null : tmpIsShowTips == 1;
        if (in.readByte() == 0) {
            lmb1 = null;
        } else {
            lmb1 = in.readInt();
        }
        if (in.readByte() == 0) {
            lmb2 = null;
        } else {
            lmb2 = in.readInt();
        }
        lst6Bl = in.readString();
        lstWkt = in.readString();
        mCurSts = in.readString();
        mDt = in.readString();
        mDy = in.readString();
        mNo = in.readString();
        mSts = in.readString();
        mTips = in.readString();
        mTipsHist = in.readString();
        mTm = in.readString();
        matchEndDateTime = in.readString();
        matchStartDateTime = in.readString();
        mcYesNo = in.readString();
        mtYesNo = in.readString();
        nt1 = in.readString();
        nt2 = in.readString();
        nt3 = in.readString();
        nt4 = in.readString();
        nt5 = in.readString();
        nt6 = in.readString();
        oddDiff = in.readString();
        oddDiffMC = in.readString();
        oddDiffMT = in.readString();
        oddsHistId = in.readString();
        oddsHistId1 = in.readString();
        onBt = in.readString();
        pAdBk = in.readString();
        pTvAdBk = in.readString();
        rnNd = in.readString();
        rqRnRt = in.readString();
        sNm = in.readString();
        sessionInfo = in.readString();
        sessionKey = in.readString();
        byte tmpShowScroller = in.readByte();
        showScroller = tmpShowScroller == 0 ? null : tmpShowScroller == 1;
        byte tmpShwTps = in.readByte();
        shwTps = tmpShwTps == 0 ? null : tmpShwTps == 1;
        byte tmpSs1 = in.readByte();
        ss1 = tmpSs1 == 0 ? null : tmpSs1 == 1;
        byte tmpSs2 = in.readByte();
        ss2 = tmpSs2 == 0 ? null : tmpSs2 == 1;
        byte tmpSs3 = in.readByte();
        ss3 = tmpSs3 == 0 ? null : tmpSs3 == 1;
        byte tmpSs4 = in.readByte();
        ss4 = tmpSs4 == 0 ? null : tmpSs4 == 1;
        byte tmpSs5 = in.readByte();
        ss5 = tmpSs5 == 0 ? null : tmpSs5 == 1;
        byte tmpSs6 = in.readByte();
        ss6 = tmpSs6 == 0 ? null : tmpSs6 == 1;
        ssOvr1 = in.readString();
        ssOvr2 = in.readString();
        ssOvr3 = in.readString();
        ssOvr4 = in.readString();
        ssOvr5 = in.readString();
        ssOvr6 = in.readString();
        byte tmpSsSpd1 = in.readByte();
        ssSpd1 = tmpSsSpd1 == 0 ? null : tmpSsSpd1 == 1;
        byte tmpSsSpd2 = in.readByte();
        ssSpd2 = tmpSsSpd2 == 0 ? null : tmpSsSpd2 == 1;
        byte tmpSsSpd3 = in.readByte();
        ssSpd3 = tmpSsSpd3 == 0 ? null : tmpSsSpd3 == 1;
        byte tmpSsSpd4 = in.readByte();
        ssSpd4 = tmpSsSpd4 == 0 ? null : tmpSsSpd4 == 1;
        byte tmpSsSpd5 = in.readByte();
        ssSpd5 = tmpSsSpd5 == 0 ? null : tmpSsSpd5 == 1;
        byte tmpSsSpd6 = in.readByte();
        ssSpd6 = tmpSsSpd6 == 0 ? null : tmpSsSpd6 == 1;
        t1 = in.readString();
        t1Back = in.readString();
        t1BackMC = in.readString();
        t1BackMT = in.readString();
        t1CurOvr = in.readString();
        t1Lay = in.readString();
        t1LayMC = in.readString();
        t1LayMT = in.readString();
        t1Rn = in.readString();
        t1TotOvr = in.readString();
        t1Wkt = in.readString();
        t1XI = in.readString();
        t1Short = in.readString();
        t2 = in.readString();
        t2Back = in.readString();
        t2BackMC = in.readString();
        t2BackMT = in.readString();
        t2CurOvr = in.readString();
        t2Lay = in.readString();
        t2LayMC = in.readString();
        t2LayMT = in.readString();
        t2Rn = in.readString();
        t2TotOvr = in.readString();
        t2Wkt = in.readString();
        t2XI = in.readString();
        t2Short = in.readString();
        trgt = in.readString();
        tvPrivateAdBk = in.readString();
        updatedFancyInfo = in.readString();
        wethr = in.readString();
        if (in.readByte() == 0) {
            yes1 = null;
        } else {
            yes1 = in.readInt();
        }
        if (in.readByte() == 0) {
            yes2 = null;
        } else {
            yes2 = in.readInt();
        }
        if (in.readByte() == 0) {
            yes3 = null;
        } else {
            yes3 = in.readInt();
        }
        if (in.readByte() == 0) {
            yes4 = null;
        } else {
            yes4 = in.readInt();
        }
        if (in.readByte() == 0) {
            yes5 = null;
        } else {
            yes5 = in.readInt();
        }
        if (in.readByte() == 0) {
            yes6 = null;
        } else {
            yes6 = in.readInt();
        }
    }

    public static final Creator<UpcomingDataModel> CREATOR = new Creator<UpcomingDataModel>() {
        @Override
        public UpcomingDataModel createFromParcel(Parcel in) {
            return new UpcomingDataModel(in);
        }

        @Override
        public UpcomingDataModel[] newArray(int size) {
            return new UpcomingDataModel[size];
        }
    };

    public String getAdBk() {
        return adBk;
    }

    public void setAdBk(String adBk) {
        this.adBk = adBk;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public Boolean getAtOddsHist() {
        return atOddsHist;
    }

    public void setAtOddsHist(Boolean atOddsHist) {
        this.atOddsHist = atOddsHist;
    }

    public String getBlRem() {
        return blRem;
    }

    public void setBlRem(String blRem) {
        this.blRem = blRem;
    }

    public String getBtsM1() {
        return btsM1;
    }

    public void setBtsM1(String btsM1) {
        this.btsM1 = btsM1;
    }

    public String getBtsM1Bls() {
        return btsM1Bls;
    }

    public void setBtsM1Bls(String btsM1Bls) {
        this.btsM1Bls = btsM1Bls;
    }

    public String getBtsM1Rn() {
        return btsM1Rn;
    }

    public void setBtsM1Rn(String btsM1Rn) {
        this.btsM1Rn = btsM1Rn;
    }

    public String getBtsM2() {
        return btsM2;
    }

    public void setBtsM2(String btsM2) {
        this.btsM2 = btsM2;
    }

    public String getBtsM2Bls() {
        return btsM2Bls;
    }

    public void setBtsM2Bls(String btsM2Bls) {
        this.btsM2Bls = btsM2Bls;
    }

    public String getBtsM2Rn() {
        return btsM2Rn;
    }

    public void setBtsM2Rn(String btsM2Rn) {
        this.btsM2Rn = btsM2Rn;
    }

    public String getBtsMStrk() {
        return btsMStrk;
    }

    public void setBtsMStrk(String btsMStrk) {
        this.btsMStrk = btsMStrk;
    }

    public String getBwl() {
        return bwl;
    }

    public void setBwl(String bwl) {
        this.bwl = bwl;
    }

    public String getBwlOvr() {
        return bwlOvr;
    }

    public void setBwlOvr(String bwlOvr) {
        this.bwlOvr = bwlOvr;
    }

    public String getBwlRn() {
        return bwlRn;
    }

    public void setBwlRn(String bwlRn) {
        this.bwlRn = bwlRn;
    }

    public String getBwlWkt() {
        return bwlWkt;
    }

    public void setBwlWkt(String bwlWkt) {
        this.bwlWkt = bwlWkt;
    }

    public String getContestUrl() {
        return contestUrl;
    }

    public void setContestUrl(String contestUrl) {
        this.contestUrl = contestUrl;
    }

    public String getCricURL() {
        return cricURL;
    }

    public void setCricURL(String cricURL) {
        this.cricURL = cricURL;
    }

    public String getCurRnRt() {
        return curRnRt;
    }

    public void setCurRnRt(String curRnRt) {
        this.curRnRt = curRnRt;
    }

    public String getCurScMsg() {
        return curScMsg;
    }

    public void setCurScMsg(String curScMsg) {
        this.curScMsg = curScMsg;
    }

    public String getFancyInfo() {
        return fancyInfo;
    }

    public void setFancyInfo(Boolean fancyInfo) {
        isFancyInfo = fancyInfo;
    }

    public Boolean getMatchComplete() {
        return isMatchComplete;
    }

    public void setMatchComplete(Boolean matchComplete) {
        isMatchComplete = matchComplete;
    }

    public Boolean getMatchOdds() {
        return isMatchOdds;
    }

    public void setMatchOdds(Boolean matchOdds) {
        isMatchOdds = matchOdds;
    }

    public Boolean getMatchTied() {
        return isMatchTied;
    }

    public void setMatchTied(Boolean matchTied) {
        isMatchTied = matchTied;
    }

    public Boolean getTied() {
        return isTied;
    }

    public void setTied(Boolean tied) {
        isTied = tied;
    }

    public Boolean getContestEnable() {
        return isContestEnable;
    }

    public void setContestEnable(Boolean contestEnable) {
        isContestEnable = contestEnable;
    }

    public Boolean getRain() {
        return isRain;
    }

    public void setRain(Boolean rain) {
        isRain = rain;
    }

    public Boolean getShowTips() {
        return isShowTips;
    }

    public void setShowTips(Boolean showTips) {
        isShowTips = showTips;
    }

    public Integer getLmb1() {
        return lmb1;
    }

    public void setLmb1(Integer lmb1) {
        this.lmb1 = lmb1;
    }

    public Integer getLmb2() {
        return lmb2;
    }

    public void setLmb2(Integer lmb2) {
        this.lmb2 = lmb2;
    }

    public String getLst6Bl() {
        return lst6Bl;
    }

    public void setLst6Bl(String lst6Bl) {
        this.lst6Bl = lst6Bl;
    }

    public String getLstWkt() {
        return lstWkt;
    }

    public void setLstWkt(String lstWkt) {
        this.lstWkt = lstWkt;
    }

    public String getmCurSts() {
        return mCurSts;
    }

    public void setmCurSts(String mCurSts) {
        this.mCurSts = mCurSts;
    }

    public String getmDt() {
        return mDt;
    }

    public void setmDt(String mDt) {
        this.mDt = mDt;
    }

    public String getmDy() {
        return mDy;
    }

    public void setmDy(String mDy) {
        this.mDy = mDy;
    }

    public String getmNo() {
        return mNo;
    }

    public void setmNo(String mNo) {
        this.mNo = mNo;
    }

    public String getmSts() {
        return mSts;
    }

    public void setmSts(String mSts) {
        this.mSts = mSts;
    }

    public String getmTips() {
        return mTips;
    }

    public void setmTips(String mTips) {
        this.mTips = mTips;
    }

    public String getmTipsHist() {
        return mTipsHist;
    }

    public void setmTipsHist(String mTipsHist) {
        this.mTipsHist = mTipsHist;
    }

    public String getmTm() {
        return mTm;
    }

    public void setmTm(String mTm) {
        this.mTm = mTm;
    }

    public String getMatchEndDateTime() {
        return matchEndDateTime;
    }

    public void setMatchEndDateTime(String matchEndDateTime) {
        this.matchEndDateTime = matchEndDateTime;
    }

    public String getMatchStartDateTime() {
        return matchStartDateTime;
    }

    public void setMatchStartDateTime(String matchStartDateTime) {
        this.matchStartDateTime = matchStartDateTime;
    }

    public String getMcYesNo() {
        return mcYesNo;
    }

    public void setMcYesNo(String mcYesNo) {
        this.mcYesNo = mcYesNo;
    }

    public String getMtYesNo() {
        return mtYesNo;
    }

    public void setMtYesNo(String mtYesNo) {
        this.mtYesNo = mtYesNo;
    }

    public String getNt1() {
        return nt1;
    }

    public void setNt1(String nt1) {
        this.nt1 = nt1;
    }

    public String getNt2() {
        return nt2;
    }

    public void setNt2(String nt2) {
        this.nt2 = nt2;
    }

    public String getNt3() {
        return nt3;
    }

    public void setNt3(String nt3) {
        this.nt3 = nt3;
    }

    public String getNt4() {
        return nt4;
    }

    public void setNt4(String nt4) {
        this.nt4 = nt4;
    }

    public String getNt5() {
        return nt5;
    }

    public void setNt5(String nt5) {
        this.nt5 = nt5;
    }

    public String getNt6() {
        return nt6;
    }

    public void setNt6(String nt6) {
        this.nt6 = nt6;
    }

    public String getOddDiff() {
        return oddDiff;
    }

    public void setOddDiff(String oddDiff) {
        this.oddDiff = oddDiff;
    }

    public String getOddDiffMC() {
        return oddDiffMC;
    }

    public void setOddDiffMC(String oddDiffMC) {
        this.oddDiffMC = oddDiffMC;
    }

    public String getOddDiffMT() {
        return oddDiffMT;
    }

    public void setOddDiffMT(String oddDiffMT) {
        this.oddDiffMT = oddDiffMT;
    }

    public String getOddsHistId() {
        return oddsHistId;
    }

    public void setOddsHistId(String oddsHistId) {
        this.oddsHistId = oddsHistId;
    }

    public String getOddsHistId1() {
        return oddsHistId1;
    }

    public void setOddsHistId1(String oddsHistId1) {
        this.oddsHistId1 = oddsHistId1;
    }

    public String getOnBt() {
        return onBt;
    }

    public void setOnBt(String onBt) {
        this.onBt = onBt;
    }

    public String getpAdBk() {
        return pAdBk;
    }

    public void setpAdBk(String pAdBk) {
        this.pAdBk = pAdBk;
    }

    public String getpTvAdBk() {
        return pTvAdBk;
    }

    public void setpTvAdBk(String pTvAdBk) {
        this.pTvAdBk = pTvAdBk;
    }

    public String getRnNd() {
        return rnNd;
    }

    public void setRnNd(String rnNd) {
        this.rnNd = rnNd;
    }

    public String getRqRnRt() {
        return rqRnRt;
    }

    public void setRqRnRt(String rqRnRt) {
        this.rqRnRt = rqRnRt;
    }

    public String getsNm() {
        return sNm;
    }

    public void setsNm(String sNm) {
        this.sNm = sNm;
    }

    public String getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(String sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Boolean getShowScroller() {
        return showScroller;
    }

    public void setShowScroller(Boolean showScroller) {
        this.showScroller = showScroller;
    }

    public Boolean getShwTps() {
        return shwTps;
    }

    public void setShwTps(Boolean shwTps) {
        this.shwTps = shwTps;
    }

    public Boolean getSs1() {
        return ss1;
    }

    public void setSs1(Boolean ss1) {
        this.ss1 = ss1;
    }

    public Boolean getSs2() {
        return ss2;
    }

    public void setSs2(Boolean ss2) {
        this.ss2 = ss2;
    }

    public Boolean getSs3() {
        return ss3;
    }

    public void setSs3(Boolean ss3) {
        this.ss3 = ss3;
    }

    public Boolean getSs4() {
        return ss4;
    }

    public void setSs4(Boolean ss4) {
        this.ss4 = ss4;
    }

    public Boolean getSs5() {
        return ss5;
    }

    public void setSs5(Boolean ss5) {
        this.ss5 = ss5;
    }

    public Boolean getSs6() {
        return ss6;
    }

    public void setSs6(Boolean ss6) {
        this.ss6 = ss6;
    }

    public String getSsOvr1() {
        return ssOvr1;
    }

    public void setSsOvr1(String ssOvr1) {
        this.ssOvr1 = ssOvr1;
    }

    public String getSsOvr2() {
        return ssOvr2;
    }

    public void setSsOvr2(String ssOvr2) {
        this.ssOvr2 = ssOvr2;
    }

    public String getSsOvr3() {
        return ssOvr3;
    }

    public void setSsOvr3(String ssOvr3) {
        this.ssOvr3 = ssOvr3;
    }

    public String getSsOvr4() {
        return ssOvr4;
    }

    public void setSsOvr4(String ssOvr4) {
        this.ssOvr4 = ssOvr4;
    }

    public String getSsOvr5() {
        return ssOvr5;
    }

    public void setSsOvr5(String ssOvr5) {
        this.ssOvr5 = ssOvr5;
    }

    public String getSsOvr6() {
        return ssOvr6;
    }

    public void setSsOvr6(String ssOvr6) {
        this.ssOvr6 = ssOvr6;
    }

    public Boolean getSsSpd1() {
        return ssSpd1;
    }

    public void setSsSpd1(Boolean ssSpd1) {
        this.ssSpd1 = ssSpd1;
    }

    public Boolean getSsSpd2() {
        return ssSpd2;
    }

    public void setSsSpd2(Boolean ssSpd2) {
        this.ssSpd2 = ssSpd2;
    }

    public Boolean getSsSpd3() {
        return ssSpd3;
    }

    public void setSsSpd3(Boolean ssSpd3) {
        this.ssSpd3 = ssSpd3;
    }

    public Boolean getSsSpd4() {
        return ssSpd4;
    }

    public void setSsSpd4(Boolean ssSpd4) {
        this.ssSpd4 = ssSpd4;
    }

    public Boolean getSsSpd5() {
        return ssSpd5;
    }

    public void setSsSpd5(Boolean ssSpd5) {
        this.ssSpd5 = ssSpd5;
    }

    public Boolean getSsSpd6() {
        return ssSpd6;
    }

    public void setSsSpd6(Boolean ssSpd6) {
        this.ssSpd6 = ssSpd6;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT1Back() {
        return t1Back;
    }

    public void setT1Back(String t1Back) {
        this.t1Back = t1Back;
    }

    public String getT1BackMC() {
        return t1BackMC;
    }

    public void setT1BackMC(String t1BackMC) {
        this.t1BackMC = t1BackMC;
    }

    public String getT1BackMT() {
        return t1BackMT;
    }

    public void setT1BackMT(String t1BackMT) {
        this.t1BackMT = t1BackMT;
    }

    public String getT1CurOvr() {
        return t1CurOvr;
    }

    public void setT1CurOvr(String t1CurOvr) {
        this.t1CurOvr = t1CurOvr;
    }

    public String getT1Lay() {
        return t1Lay;
    }

    public void setT1Lay(String t1Lay) {
        this.t1Lay = t1Lay;
    }

    public String getT1LayMC() {
        return t1LayMC;
    }

    public void setT1LayMC(String t1LayMC) {
        this.t1LayMC = t1LayMC;
    }

    public String getT1LayMT() {
        return t1LayMT;
    }

    public void setT1LayMT(String t1LayMT) {
        this.t1LayMT = t1LayMT;
    }

    public String getT1Rn() {
        return t1Rn;
    }

    public void setT1Rn(String t1Rn) {
        this.t1Rn = t1Rn;
    }

    public String getT1TotOvr() {
        return t1TotOvr;
    }

    public void setT1TotOvr(String t1TotOvr) {
        this.t1TotOvr = t1TotOvr;
    }

    public String getT1Wkt() {
        return t1Wkt;
    }

    public void setT1Wkt(String t1Wkt) {
        this.t1Wkt = t1Wkt;
    }

    public String getT1XI() {
        return t1XI;
    }

    public void setT1XI(String t1XI) {
        this.t1XI = t1XI;
    }

    public String getT1Short() {
        return t1Short;
    }

    public void setT1Short(String t1Short) {
        this.t1Short = t1Short;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT2Back() {
        return t2Back;
    }

    public void setT2Back(String t2Back) {
        this.t2Back = t2Back;
    }

    public String getT2BackMC() {
        return t2BackMC;
    }

    public void setT2BackMC(String t2BackMC) {
        this.t2BackMC = t2BackMC;
    }

    public String getT2BackMT() {
        return t2BackMT;
    }

    public void setT2BackMT(String t2BackMT) {
        this.t2BackMT = t2BackMT;
    }

    public String getT2CurOvr() {
        return t2CurOvr;
    }

    public void setT2CurOvr(String t2CurOvr) {
        this.t2CurOvr = t2CurOvr;
    }

    public String getT2Lay() {
        return t2Lay;
    }

    public void setT2Lay(String t2Lay) {
        this.t2Lay = t2Lay;
    }

    public String getT2LayMC() {
        return t2LayMC;
    }

    public void setT2LayMC(String t2LayMC) {
        this.t2LayMC = t2LayMC;
    }

    public String getT2LayMT() {
        return t2LayMT;
    }

    public void setT2LayMT(String t2LayMT) {
        this.t2LayMT = t2LayMT;
    }

    public String getT2Rn() {
        return t2Rn;
    }

    public void setT2Rn(String t2Rn) {
        this.t2Rn = t2Rn;
    }

    public String getT2TotOvr() {
        return t2TotOvr;
    }

    public void setT2TotOvr(String t2TotOvr) {
        this.t2TotOvr = t2TotOvr;
    }

    public String getT2Wkt() {
        return t2Wkt;
    }

    public void setT2Wkt(String t2Wkt) {
        this.t2Wkt = t2Wkt;
    }

    public String getT2XI() {
        return t2XI;
    }

    public void setT2XI(String t2XI) {
        this.t2XI = t2XI;
    }

    public String getT2Short() {
        return t2Short;
    }

    public void setT2Short(String t2Short) {
        this.t2Short = t2Short;
    }

    public String getTrgt() {
        return trgt;
    }

    public void setTrgt(String trgt) {
        this.trgt = trgt;
    }

    public String getTvPrivateAdBk() {
        return tvPrivateAdBk;
    }

    public void setTvPrivateAdBk(String tvPrivateAdBk) {
        this.tvPrivateAdBk = tvPrivateAdBk;
    }

    public String getUpdatedFancyInfo() {
        return updatedFancyInfo;
    }

    public void setUpdatedFancyInfo(String updatedFancyInfo) {
        this.updatedFancyInfo = updatedFancyInfo;
    }

    public String getWethr() {
        return wethr;
    }

    public void setWethr(String wethr) {
        this.wethr = wethr;
    }

    public Integer getYes1() {
        return yes1;
    }

    public void setYes1(Integer yes1) {
        this.yes1 = yes1;
    }

    public Integer getYes2() {
        return yes2;
    }

    public void setYes2(Integer yes2) {
        this.yes2 = yes2;
    }

    public Integer getYes3() {
        return yes3;
    }

    public void setYes3(Integer yes3) {
        this.yes3 = yes3;
    }

    public Integer getYes4() {
        return yes4;
    }

    public void setYes4(Integer yes4) {
        this.yes4 = yes4;
    }

    public Integer getYes5() {
        return yes5;
    }

    public void setYes5(Integer yes5) {
        this.yes5 = yes5;
    }

    public Integer getYes6() {
        return yes6;
    }

    public void setYes6(Integer yes6) {
        this.yes6 = yes6;
    }

    public void setFancyInfo(String fancyInfo) {
        this.fancyInfo = fancyInfo;
    }

    public String getFavTm() {
        return favTm;
    }

    public void setFavTm(String favTm) {
        this.favTm = favTm;
    }

    public Boolean getFl1() {
        return fl1;
    }

    public void setFl1(Boolean fl1) {
        this.fl1 = fl1;
    }

    public Boolean getFl2() {
        return fl2;
    }

    public void setFl2(Boolean fl2) {
        this.fl2 = fl2;
    }

    public String getFullScorecard() {
        return fullScorecard;
    }

    public void setFullScorecard(String fullScorecard) {
        this.fullScorecard = fullScorecard;
    }

    public String getFwd1() {
        return fwd1;
    }

    public void setFwd1(String fwd1) {
        this.fwd1 = fwd1;
    }

    public String getFwd2() {
        return fwd2;
    }

    public void setFwd2(String fwd2) {
        this.fwd2 = fwd2;
    }

    public String getFwdLmbOvr1() {
        return fwdLmbOvr1;
    }

    public void setFwdLmbOvr1(String fwdLmbOvr1) {
        this.fwdLmbOvr1 = fwdLmbOvr1;
    }

    public String getFwdLmbOvr2() {
        return fwdLmbOvr2;
    }

    public void setFwdLmbOvr2(String fwdLmbOvr2) {
        this.fwdLmbOvr2 = fwdLmbOvr2;
    }

    public String getgNm() {
        return gNm;
    }

    public void setgNm(String gNm) {
        this.gNm = gNm;
    }

    public String getGoogleAdBk() {
        return googleAdBk;
    }

    public void setGoogleAdBk(String googleAdBk) {
        this.googleAdBk = googleAdBk;
    }

    public Boolean getHsFlScBd() {
        return hsFlScBd;
    }

    public void setHsFlScBd(Boolean hsFlScBd) {
        this.hsFlScBd = hsFlScBd;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(adBk);
        parcel.writeString(addInfo);
        parcel.writeByte((byte) (atOddsHist == null ? 0 : atOddsHist ? 1 : 2));
        parcel.writeString(blRem);
        parcel.writeString(btsM1);
        parcel.writeString(btsM1Bls);
        parcel.writeString(btsM1Rn);
        parcel.writeString(btsM2);
        parcel.writeString(btsM2Bls);
        parcel.writeString(btsM2Rn);
        parcel.writeString(btsMStrk);
        parcel.writeString(bwl);
        parcel.writeString(bwlOvr);
        parcel.writeString(bwlRn);
        parcel.writeString(bwlWkt);
        parcel.writeString(contestUrl);
        parcel.writeString(cricURL);
        parcel.writeString(curRnRt);
        parcel.writeString(curScMsg);
        parcel.writeString(fancyInfo);
        parcel.writeString(favTm);
        parcel.writeByte((byte) (fl1 == null ? 0 : fl1 ? 1 : 2));
        parcel.writeByte((byte) (fl2 == null ? 0 : fl2 ? 1 : 2));
        parcel.writeString(fullScorecard);
        parcel.writeString(fwd1);
        parcel.writeString(fwd2);
        parcel.writeString(fwdLmbOvr1);
        parcel.writeString(fwdLmbOvr2);
        parcel.writeString(gNm);
        parcel.writeString(googleAdBk);
        parcel.writeByte((byte) (hsFlScBd == null ? 0 : hsFlScBd ? 1 : 2));
        parcel.writeString(info);
        parcel.writeString(ing);
        parcel.writeByte((byte) (isCompleted == null ? 0 : isCompleted ? 1 : 2));
        parcel.writeByte((byte) (isFancyInfo == null ? 0 : isFancyInfo ? 1 : 2));
        parcel.writeByte((byte) (isMatchComplete == null ? 0 : isMatchComplete ? 1 : 2));
        parcel.writeByte((byte) (isMatchOdds == null ? 0 : isMatchOdds ? 1 : 2));
        parcel.writeByte((byte) (isMatchTied == null ? 0 : isMatchTied ? 1 : 2));
        parcel.writeByte((byte) (isTied == null ? 0 : isTied ? 1 : 2));
        parcel.writeByte((byte) (isContestEnable == null ? 0 : isContestEnable ? 1 : 2));
        parcel.writeByte((byte) (isRain == null ? 0 : isRain ? 1 : 2));
        parcel.writeByte((byte) (isShowTips == null ? 0 : isShowTips ? 1 : 2));
        if (lmb1 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(lmb1);
        }
        if (lmb2 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(lmb2);
        }
        parcel.writeString(lst6Bl);
        parcel.writeString(lstWkt);
        parcel.writeString(mCurSts);
        parcel.writeString(mDt);
        parcel.writeString(mDy);
        parcel.writeString(mNo);
        parcel.writeString(mSts);
        parcel.writeString(mTips);
        parcel.writeString(mTipsHist);
        parcel.writeString(mTm);
        parcel.writeString(matchEndDateTime);
        parcel.writeString(matchStartDateTime);
        parcel.writeString(mcYesNo);
        parcel.writeString(mtYesNo);
        parcel.writeString(nt1);
        parcel.writeString(nt2);
        parcel.writeString(nt3);
        parcel.writeString(nt4);
        parcel.writeString(nt5);
        parcel.writeString(nt6);
        parcel.writeString(oddDiff);
        parcel.writeString(oddDiffMC);
        parcel.writeString(oddDiffMT);
        parcel.writeString(oddsHistId);
        parcel.writeString(oddsHistId1);
        parcel.writeString(onBt);
        parcel.writeString(pAdBk);
        parcel.writeString(pTvAdBk);
        parcel.writeString(rnNd);
        parcel.writeString(rqRnRt);
        parcel.writeString(sNm);
        parcel.writeString(sessionInfo);
        parcel.writeString(sessionKey);
        parcel.writeByte((byte) (showScroller == null ? 0 : showScroller ? 1 : 2));
        parcel.writeByte((byte) (shwTps == null ? 0 : shwTps ? 1 : 2));
        parcel.writeByte((byte) (ss1 == null ? 0 : ss1 ? 1 : 2));
        parcel.writeByte((byte) (ss2 == null ? 0 : ss2 ? 1 : 2));
        parcel.writeByte((byte) (ss3 == null ? 0 : ss3 ? 1 : 2));
        parcel.writeByte((byte) (ss4 == null ? 0 : ss4 ? 1 : 2));
        parcel.writeByte((byte) (ss5 == null ? 0 : ss5 ? 1 : 2));
        parcel.writeByte((byte) (ss6 == null ? 0 : ss6 ? 1 : 2));
        parcel.writeString(ssOvr1);
        parcel.writeString(ssOvr2);
        parcel.writeString(ssOvr3);
        parcel.writeString(ssOvr4);
        parcel.writeString(ssOvr5);
        parcel.writeString(ssOvr6);
        parcel.writeByte((byte) (ssSpd1 == null ? 0 : ssSpd1 ? 1 : 2));
        parcel.writeByte((byte) (ssSpd2 == null ? 0 : ssSpd2 ? 1 : 2));
        parcel.writeByte((byte) (ssSpd3 == null ? 0 : ssSpd3 ? 1 : 2));
        parcel.writeByte((byte) (ssSpd4 == null ? 0 : ssSpd4 ? 1 : 2));
        parcel.writeByte((byte) (ssSpd5 == null ? 0 : ssSpd5 ? 1 : 2));
        parcel.writeByte((byte) (ssSpd6 == null ? 0 : ssSpd6 ? 1 : 2));
        parcel.writeString(t1);
        parcel.writeString(t1Back);
        parcel.writeString(t1BackMC);
        parcel.writeString(t1BackMT);
        parcel.writeString(t1CurOvr);
        parcel.writeString(t1Lay);
        parcel.writeString(t1LayMC);
        parcel.writeString(t1LayMT);
        parcel.writeString(t1Rn);
        parcel.writeString(t1TotOvr);
        parcel.writeString(t1Wkt);
        parcel.writeString(t1XI);
        parcel.writeString(t1Short);
        parcel.writeString(t2);
        parcel.writeString(t2Back);
        parcel.writeString(t2BackMC);
        parcel.writeString(t2BackMT);
        parcel.writeString(t2CurOvr);
        parcel.writeString(t2Lay);
        parcel.writeString(t2LayMC);
        parcel.writeString(t2LayMT);
        parcel.writeString(t2Rn);
        parcel.writeString(t2TotOvr);
        parcel.writeString(t2Wkt);
        parcel.writeString(t2XI);
        parcel.writeString(t2Short);
        parcel.writeString(trgt);
        parcel.writeString(tvPrivateAdBk);
        parcel.writeString(updatedFancyInfo);
        parcel.writeString(wethr);
        if (yes1 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(yes1);
        }
        if (yes2 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(yes2);
        }
        if (yes3 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(yes3);
        }
        if (yes4 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(yes4);
        }
        if (yes5 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(yes5);
        }
        if (yes6 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(yes6);
        }
    }
}
