import { NavLink} from "react-router"


function PageNotFound() {
    return (
      <div className="flex flex-col items-center justify-center min-h-screen bg-gray-50 text-gray-800">
        <h1 className="text-6xl font-bold mb-4">404</h1>
        <p className="text-xl mb-6">Oops! Page not found.</p>
        <NavLink
            to="/"
            className="px-6 py-3 bg-blue-500 text-white rounded hover:bg-blue-600 transition"
        >
            Go Home
        </NavLink>
      </div>
    )
}

export default PageNotFound;