import "./App.css";
import Reward from "./pages/Reward/Reward";
import InvestBasicInfo from "./Component/InvestMake/InvestBasicInfo";
import { Route, Routes } from "react-router-dom";
import Story from "./Component/RewardDetail/Detail/Story";
import Contact from "./Component/RewardDetail/Detail/Contact";
import Guide from "./Component/RewardDetail/Detail/Guide";
import Fund from "./pages/Fund/Fund";
import FundStory from "./Component/FundDetail/Detail/FundStroy";
import FundContact from "./Component/FundDetail/Detail/FundContact";
import FundGuide from "./Component/FundDetail/Detail/FundGuide";
import CheckCategory from "./Component/Checkout/CheckCategory";
import Checkout from "./Component/Checkout/Checkout";
import CheckoutComplete from "./Component/Checkout/CheckoutComplete";
import FundPeople from "./Component/Checkout/FundPeople";
import Checkfund from "./Component/Checkout/Checkfund";
import FundCheckout from "./Component/Checkout/FundCheckout";
import Founder from "./pages/MyPage/Founder";
import Investor from "./pages/MyPage/Investor";
function App() {
  return (
    <div className="App">
      <Routes>
        {/* <Route exact path="/" element={<Main />} /> */}
        <Route exact path="/reward" element={<Reward />} />
      </Routes>
      <Routes>
        <Route exact path="/my-page/founder" element={<Founder />} />
        <Route exact path="/my-page/investor" element={<Investor />} />
      </Routes>
      <Routes>
        <Route exact path="/reward-detail/story" element={<Story />} />
        <Route exact path="/reward-detail/contact" element={<Contact />} />
        <Route exact path="/reward-detail/guide" element={<Guide />} />
      </Routes>
      <Routes>
        <Route exact path="/fund" element={<Fund />} />
      </Routes>
      <Routes>

        <Route exact path="/fund-detail/story" element={<FundStory />} />
        <Route exact path="/fund-detail/contact" element={<FundContact />} />
        <Route exact path="/fund-detail/guide" element={<FundGuide />} />
      </Routes>
      <Routes>
        <Route exact path="/checkout/check" element={<CheckCategory />} />
        <Route exact path="/reward-checkout" element={<Checkout />} />
        <Route
          exact
          path="/reward-checkout/complete"
          element={<CheckoutComplete />}
        />
      </Routes>
      <Routes>
        <Route
          exact
          path="/fund-checkout/fundpeople"
          element={<FundPeople />}
        />
        <Route exact path="/fund-checkout/checkfund" element={<Checkfund />} />
        <Route
          exact
          path="/fund-checkout/checkout"
          element={<FundCheckout />}
        />
        <Route
          exact
          path="/fund-checkout/complete"
          element={<CheckoutComplete />}
        />
      </Routes>
      {/* <InvestBasicInfo /> */}
    </div>
  );
}

export default App;
