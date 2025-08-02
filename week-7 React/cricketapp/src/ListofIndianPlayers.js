import React from "react";

// merged players array prop is expected
const ListofIndianPlayers = ({ IndianPlayers=[] }) => (
  <ul>
    {IndianPlayers.map((player, i) => <li key={i}>{player}</li>)}
  </ul>
);

export default ListofIndianPlayers;
