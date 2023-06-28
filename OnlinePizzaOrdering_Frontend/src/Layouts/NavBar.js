import React, { useState } from 'react';
import {
    MDBNavbar,
    MDBContainer,
    MDBIcon,
    MDBNavbarNav,
    MDBNavbarItem,
    MDBNavbarLink,
    MDBNavbarToggler,
    MDBNavbarBrand,
    MDBCollapse
} from 'mdb-react-ui-kit';


import { MDBDropdown, MDBDropdownMenu, MDBDropdownToggle, MDBDropdownItem } from 'mdb-react-ui-kit';

import logo from '../Assets/HomePizzaLogo.gif';
import { useNavigate } from 'react-router-dom';



const NavBar = () => {
    const [showNavColor, setShowNavColor] = useState(false);

    const navigate = useNavigate;



    // var Logout = () => {
    //     sessionStorage.removeItem("isLoggedIn");
    //     sessionStorage.removeItem("userName");
    //     sessionStorage.removeItem("userId");
    //     sessionStorage.removeItem("userRole");
    //     navigate.push("/login")
    //   }



    return (
        <MDBNavbar expand="lg" dark bgColor="primary">
            <MDBContainer fluid>
                <MDBNavbarBrand href="/">
                    <img src={logo} alt="Logo" /> PIZZATERIA
                </MDBNavbarBrand>
                <MDBNavbarToggler
                    type="button"
                    data-target="#navbarColor02"
                    aria-controls="navbarColor02"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    onClick={() => setShowNavColor(!showNavColor)}
                >
                    <MDBIcon icon="bars" fas />
                </MDBNavbarToggler>
                <MDBCollapse show={showNavColor} navbar>
                    <MDBNavbarNav className="me-auto mb-2 mb-lg-0">
                        <MDBNavbarItem>
                            <MDBNavbarLink aria-current="page" href="http://localhost:3000/">
                                Home
                            </MDBNavbarLink>
                        </MDBNavbarItem>
                        <MDBNavbarItem>
                            <MDBNavbarLink href="http://localhost:3000/aboutus">
                                About
                            </MDBNavbarLink>
                        </MDBNavbarItem>
                        <MDBNavbarItem>
                            <MDBNavbarLink href="http://localhost:3000/contactus">
                                Contact Us
                            </MDBNavbarLink>
                        </MDBNavbarItem>
                        <div className="dropdown" style={{ marginLeft: '10px' }}>
                            <button
                                className="btn btn-secondary dropdown-toggle"
                                type="button"
                                data-bs-toggle="dropdown"
                                aria-expanded="false"
                            >
                                Select A Category
                            </button>
                            <ul className="dropdown-menu">
                                <li>
                                    <a className="dropdown-item" href="#">
                                        All
                                    </a>
                                </li>
                                {/* {category.map((categ) => (
                  // <option key={categ.id} value={categ} onClick={()=>{updateCat(categ.id)}}>{categ.categoryName}</option>
                  <li>
                    <a className="dropdown-item" href="#">
                      {categ.categoryName}
                    </a>
                  </li>
                ))} */}
                            </ul>
                        </div>
                    </MDBNavbarNav>

                    {/* Cart button */}
                    <a href="http://localhost:3000/cart" className="btn btn-secondary" style={{ marginRight: '14px'}}>
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="16"
                            height="16"
                            fill="currentColor"
                            className="bi bi-cart"
                            viewBox="0 0 16 16"
                        >
                            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                        </svg>
                    </a>

                    {/* Profile button */}
                    <MDBDropdown>
                        <MDBDropdownToggle tag='b' className='btn btn-primary'style={{ backgroundColor: 'darkblue', color: 'white'}} >
                            {/* Profile */}
                            <span className="white-text">Profile</span>
                        </MDBDropdownToggle>
                        <MDBDropdownMenu>
                            <MDBDropdownItem link>Profile</MDBDropdownItem>
                            <MDBDropdownItem link>My Orders</MDBDropdownItem>
                            <MDBDropdownItem link>My Reviews</MDBDropdownItem>
                            <MDBDropdownItem link href='http://localhost:3000/login'>Login/Logout</MDBDropdownItem>

                        </MDBDropdownMenu>
                    </MDBDropdown>


                </MDBCollapse>
            </MDBContainer>
        </MDBNavbar>
    );
};

export default NavBar;
