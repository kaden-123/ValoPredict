import { createBrowserRouter, RouterProvider } from "react-router";

import Home from "../pages/Home";
import Template from "./Template"
import ErrorPage from "../pages/ErrorPage";
import NotFound from "../pages/PageNotFound";
import History from "./player/History";
import Stats from "./player/Stats";

const navBar = createBrowserRouter([
    {
        path: "/",
        Component: Template,
        children: [
            {index: true, Component: Home,},
            {
                path: "/Player/:player_id",
                lazy: async () => {
                    const [Component, loader] = await.Promise.all([
                        import("../pages/Player"),
                        import("./player/loader"),
                    ]);
                    return { Component, loader };
                },

                children: [
                    {index: true, Component: Stats},
                    {path: "history", Component: History },
                ]
            },
            {path: "*", Component: NotFound,},
        ]
    }
])




function NavBar() {
    return (
        <>
          <RouterProvider router={navBar}/>
        </>
    )
}

export default NavBar;