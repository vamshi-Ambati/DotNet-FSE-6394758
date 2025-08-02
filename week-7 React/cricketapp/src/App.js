import React, { useState } from "react";
import ListofPlayers from "./ListofPlayers";
import IndianPlayers from "./IndianPlayers";
import "./App.css";

function App() {
  // Using ES6 const for state
  const [flag, setFlag] = useState(true);

  // ES6 array of objects
  const players = [
    { name: "Player1", score: 85 },
    { name: "Player2", score: 65 },
    { name: "Player3", score: 72 },
    { name: "Player4", score: 68 },
    { name: "Player5", score: 90 },
    { name: "Player6", score: 55 },
    { name: "Player7", score: 78 },
    { name: "Player8", score: 62 },
    { name: "Player9", score: 95 },
    { name: "Player10", score: 58 },
    { name: "Player11", score: 82 },
  ];

  return (
    <div className="App">
      <button onClick={() => setFlag(!flag)}>
        Toggle View (Current: {flag.toString()})
      </button>

      {flag ? (
        <ListofPlayers players={players} />
      ) : (
        <IndianPlayers players={players} />
      )}
    </div>
  );
}

export default App;
