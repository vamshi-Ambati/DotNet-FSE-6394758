import React, { useState } from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";
import "./App.css";

function App() {
  const [activeTab, setActiveTab] = useState("course");

  return (
    <div className="App">
      <h1>Blogger App</h1>

      <div className="tabs">
        <button
          onClick={() => setActiveTab("course")}
          className={activeTab === "course" ? "active" : ""}
        >
          Course
        </button>
        <button
          onClick={() => setActiveTab("book")}
          className={activeTab === "book" ? "active" : ""}
        >
          Book
        </button>
        <button
          onClick={() => setActiveTab("blog")}
          className={activeTab === "blog" ? "active" : ""}
        >
          Blog
        </button>
      </div>

      <div className="content">
        {activeTab === "course" && <CourseDetails />}
        {activeTab === "book" && <BookDetails />}
        {activeTab === "blog" && <BlogDetails />}
      </div>
    </div>
  );
}

export default App;
