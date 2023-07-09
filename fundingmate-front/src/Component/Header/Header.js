// components/Layout/Header/Header.tsx
import "./Header.css"
import {SearchOutlined} from "@ant-design/icons";
import {useDispatch, useSelector} from "react-redux";
import {Link} from "react-router-dom";
function Header() {
    const token = useSelector(state=>state.Authorization);
    const userid = useSelector(state=>state.UserId);

    const dispatch = useDispatch();
    const logout = () => {
        dispatch({type:"NEWTOKEN",payload:''})
        dispatch({type:"USERID",payload:''})
        document.location.href="/";
    }
    return (
        <header className="header">
            <div className="header-wrap">
                <div className="hTop">
                    <span className="hlogo">
                        <a href="/" className="hlogoL">LOGO</a>
                    </span>
                    <span className="hTopMenu">
                        {(token==''||token==undefined) &&<span><a href="login">로그인</a></span>}
                        <b>{userid}</b>&nbsp;&nbsp;{userid!=''&&<Link onClick={logout}>로그아웃</Link>}
                        <span><a href="">프로젝트 만들기</a></span>
                    </span>
                </div>
                <nav className="nav">
                    <ul className="nav-item">
                        <li><a href="">홈</a></li>
                        <li><a href="">리워드</a></li>
                        <li><a href="">창업</a></li>
                        <li><a href="">창업정보</a></li>
                        <li><a href="">오픈예정</a></li>
                    </ul>
                    <form action="search" className="searchF">
                        <input type="text" className="nav-search float-r" placeholder="프로젝트 명/기업 명" maxLength="10"/>
                    </form>
                    <a href='search' className="nav-search-btn"><SearchOutlined/></a>
                </nav>
            </div>

        </header>
    )
}

export default Header