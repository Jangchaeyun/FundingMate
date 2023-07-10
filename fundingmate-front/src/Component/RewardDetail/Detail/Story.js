import React, { useEffect, useState } from "react";
import "../../../pages/Rewarddetail/Rewarddetail.css";
import { Link, useParams } from "react-router-dom";
import Desc from "../Desc/Desc";
import axios from "axios";

const Story = () => {
  const [reward, setReward] = useState({
    id: 0,
    projName: "",
    projTargetAmount: 0,
    projDateStart: null,
    projDateEnd: null,
    repFile: null,
    projKeyword: "",
    rewardVideoAddress: "",
    conFile: null,
    projContent: "",
    rewardRefundExchangePolicy: "",
    rewardContact: "",
    rewardEmail: "",
    rewardCategory: "",
    modelName: "",
    countryOfOrigin: "",
    manufacturer: "",
    rewardLaw: "",
    asPhoneNumber: "",
    businessImg: null,
    businessAddress: "",
    bank: "",
    accNumber: "",
    depositorName: "",
    bankImg: null,
    taxBillEmail: "",
    websiteUrl: "",
    facebookUrl: "",
    instagramUrl: "",
    blogUrl: "",
    twitterUrl: "",
    user: null,
    rewardTypes: [],
  });
  const [viewDesc, setViewDesc] = useState(false);

  const { rewardId } = useParams();

  useEffect(() => {
    axios
      .get(`http://localhost:8090/reward-detail/story/${rewardId}`)
      .then((res) => {
        console.log(res.data)
        setReward(res.data.reward);
        setViewDesc(true);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <div className="desc">
      {viewDesc && <Desc reward={reward} />}
      <div className="menu">
        <hr className="menu_hr" />
        <div className="menu_items">
          <Link className="story active" to={"/reward-detail/story"}>
            스토리
          </Link>
          <div className="contact_box">
            <Link className="contact" to={"/reward-detail/contact"}>
              문의
            </Link>
            <div className="contact_count">0</div>
          </div>
          <Link className="guide" to={"/reward-detail/guide"}>
            안내
          </Link>
        </div>
      </div>
      <div className="story_content">
        {reward.projContent}
          <div className="product_img">

            {reward.conFile && (
              <img
                src={`http://localhost:8090/img/${reward.conFile.fileName}`}
                className="images"
              />
            )}
          </div>
      </div>
    </div>
  );
};

export default Story;
