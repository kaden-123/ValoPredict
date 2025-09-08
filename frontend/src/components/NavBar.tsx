import { NavLink } from "react-router-dom";
import { useState } from "react";
import { Bars3Icon, XMarkIcon } from "@heroicons/react/24/outline";

function NavBar() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <nav className="bg-white shadow-md fixed top-0 left-0 w-full z-50 px-6 py-4">
      <div className="flex justify-between items-center">
        <div className="text-xl font-bold text-gray-900">Valor Predict</div>
        <button
          className="sm:hidden text-gray-800 hover:text-blue-500 focus:outline-none"
          onClick={() => setIsOpen(!isOpen)}
        >
          {isOpen ? <XMarkIcon className="h-6 w-6" /> : <Bars3Icon className="h-6 w-6" />}
        </button>
        <ul className="hidden sm:flex sm:flex-row sm:space-x-6">
          <li>
            <NavLink
              to="/"
              end
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Home
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/a"
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Players
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/b"
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Match AI
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/c"
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Test
            </NavLink>
          </li>
        </ul>
      </div>

      <div
        className={`sm:hidden overflow-hidden transition-max-height duration-300 ease-in-out ${
          isOpen ? "max-h-96 mt-2" : "max-h-0"
        }`}
      >
        <ul className="flex flex-col items-center space-y-4">
          <li>
            <NavLink
              to="/"
              end
              onClick={() => setIsOpen(false)}
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Home
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/a"
              onClick={() => setIsOpen(false)}
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Players
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/b"
              onClick={() => setIsOpen(false)}
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Match AI
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/c"
              onClick={() => setIsOpen(false)}
              className={({ isActive }) =>
                `transition-colors hover:text-blue-500 ${
                  isActive ? "text-blue-600 font-semibold" : "text-gray-800"
                }`
              }
            >
              Test
            </NavLink>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default NavBar;
