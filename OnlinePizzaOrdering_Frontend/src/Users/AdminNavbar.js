import React from 'react'
import { Link } from 'react-router-dom'

const AdminNavbar = () => {
    return (
        <div style={{ display: "flex", justifyContent: "center", marginTop: "10px" }}>
        <nav class="navbar navbar-expand-lg bg-body-tertiary" style={{ width: "1200px" }}>
          <div class="container-fluid">
            <a href="/adduser" className="btn btn-success">Add User</a>
            {/* <a href="/adminusers" className="btn btn-success">All Users</a> */}
            <a href="/adminpizzas" className="btn btn-success">All Product</a>
            <a href="/adminorders" className="btn btn-success">All Order</a>
            <a href="/adminreviews" className="btn btn-success">All Reviews</a>
            <a href="/adminofferdisplay" className="btn btn-success">All Offer</a>
            <a href="/displaycategories" className="btn btn-success">All categories</a>
            {/* <Link to="/displaycategories" className="btn btn-success">All categories</Link> */}

          </div>
        </nav>
      </div>
      
    )
}

export default AdminNavbar

