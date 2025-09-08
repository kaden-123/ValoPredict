import { createBrowserRouter, RouterProvider } from "react-router";

import Home from "./pages/Home";
import Template from "./pages/Template"
import ErrorPage from "./pages/ErrorPage"; 
import NotFound from "./pages/PageNotFound";
import History from "./components/player/History";
import Stats from "./components/player/Stats";

const router = createBrowserRouter([
    {
        path: "/",
        Component: Template,
        children: [
            {index: true, Component: Home,},
            {
                path: "/player/:player_id",
                //idk why vscode says error here but praying to god it works
                lazy: async () => {
                    const [Component, loader] = await Promise.all([
                        import("./pages/Player"),
                        import("./components/player/loader"),
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


function App() {

  return (
    <>
      <RouterProvider router={router}/>
    </>
  )
}

export default App
