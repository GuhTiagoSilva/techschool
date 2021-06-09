import { Link } from "react-router-dom";
import { ReactComponent as MainImage } from "../../../src/assets/images/Desenho.svg";
import ButtonIcon from "../../components/ButtonIcon";
import "./styles.scss";

const Home = () => (
  <div className="home-container">
    <div className="row home-content card-base border-radius-20">
      <div className="col-6">
        <h1 className="text-title">PS13SI - Conhecimento com um CLICK!</h1>
        <p className="text-subtitle">
          Ajudaremos você a alcançar o próximo <br /> nível através de nossos
          cursos
        </p>

        <Link to="/courses">
          <ButtonIcon text="inicie agora a sua busca" />
        </Link>
      </div>

      <div className="col-6">
        <MainImage className="main-image" />
      </div>
    </div>
  </div>
);

export default Home;
