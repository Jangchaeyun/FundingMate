import React, { useState } from "react";
import "../../../Page/Rewarddetail/Rewarddetail.css";
import { ShareAltOutlined } from "@ant-design/icons";

const Desc = () => {
  const [imageSrc, setImageSrc] = useState("/assets/imgs/bracelet.jpg");
  const [isClicked, setIsClicked] = useState(false);

  const handleClick = () => {
    if (isClicked) {
      setImageSrc("/assets/imgs/bracelet.jpg");
      setIsClicked(false);
    } else {
      setImageSrc("/assets/imgs/bracelet2.jpg");
      setIsClicked(true);
    }
  };
  return (
    <div className="desc">
      <div className="desc_subtitle">
        해당 프로젝트는<b>[HandMade]</b>와 함께합니다.
      </div>
      <div className="desc_title">실버 커팅볼 스퀘어 체인 여자 팔찌</div>
      <div className="desc_contents">
        <div className="desc_img">
          <img src={imageSrc} className="main_img" />
          <img
            src="/assets/imgs/bracelet.jpg"
            className="sub_img1"
            onClick={handleClick}
          />
          <img
            src="/assets/imgs/bracelet2.jpg"
            className="sub_img2"
            onClick={handleClick}
          />
        </div>
        <div className="desc_content">
          <div className="fund_category">리워드</div>
          <div className="fund_price">
            12,345원 <b className="rewarding">펀딩중</b>
          </div>
          <div className="fund_rate">
            <div className="fund_rate_title">달성률</div>
            <div className="fund_rate_per">1050%</div>
            <sub className="fund_rate_price">목표 금액 10,0000원</sub>
          </div>
          <div className="fund_date">
            <div className="fund_date_title">남은기간</div>
            <div className="fund_date_dday">11일</div>
            <sub className="fund_date_enddate">2023.07.13 종료</sub>
          </div>
          <div className="fund_people">
            <div className="fund_people_title">참여자수</div>
            <div className="fund_people_count">140명</div>
            <button className="fund_btn">펀딩하기</button>
          </div>
          <button className="proj_share">프로젝트 공유하기</button>
        </div>
      </div>
    </div>
  );
};

export default Desc;
