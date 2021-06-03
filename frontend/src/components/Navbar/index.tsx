import React from "react";
import { Link, NavLink } from "react-router-dom";
import "./styles.scss";

const Navbar = () => {
  return (
    <nav className="row bg-primary main-nav">
      <div className="col-2">
        <Link to="/" className="nav-logo-text">
          <h4>STONKS</h4>
        </Link>
      </div>

      <div className="col-6 offset-2">
        <ul className="main-menu">
          <li>
            <NavLink to="/courses" exact>
              Cursos
            </NavLink>
          </li>
          <li>
            <NavLink to="/teachers">Professores</NavLink>
          </li>
          <li>
            <NavLink to="/users">Usuários</NavLink>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
