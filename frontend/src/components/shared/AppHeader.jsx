import "react";
import { FiGithub } from "react-icons/fi";

const AppHeader = () => {
  return (
    <nav className="fixed top-0 w-full z-50 backdrop-blur-md bg-transparent">
      <div className="container mx-auto flex items-center justify-between px-6 py-4">
        {/* Left Side: Title */}
        <h1 className="text-2xl font-bold text-gray-900 dark:text-gray-100">
          AgesOfCelebrity
        </h1>

        {/* Right Side: GitHub Button */}
        <a
          href="https://github.com/Ch1satooo/AgesOfCelebrities"
          target="_blank"
          rel="noopener noreferrer"
          className="flex items-center bg-gray-900 text-gray-100 px-3 py-2 rounded-full shadow-lg hover:opacity-80 transition duration-300"
        >
          <FiGithub />
        </a>
      </div>
    </nav>
  );
};

export default AppHeader;
