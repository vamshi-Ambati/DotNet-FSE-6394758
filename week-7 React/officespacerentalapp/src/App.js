import React from "react";
import "./App.css";

function App() {
  const officeSpaces = [
    {
      name: "Tech Hub Office",
      rent: 55000,
      address: "123 Tech Street, Bangalore",
      image:
        "https://images.unsplash.com/photo-1497366811353-6870744d04b2?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
    },
    
  ];

  return (
    <div className="App">
      <h1>Office Space Rental</h1>

      <div className="office-container">
        {officeSpaces.map((office, index) => (
          <div key={index} className="office-card">
            <img
              src={office.image}
              alt={office.name}
              className="office-image"
            />

            <div className="office-details">
              <h2>{office.name}</h2>
              <p
                className={`rent ${
                  office.rent > 50000 ? "high-rent" : "low-rent"
                }`}
              >
                Rent: ₹{office.rent.toLocaleString()}/month
              </p>
              <p>Address: {office.address}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
