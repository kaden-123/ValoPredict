export async function loader({params} : { params: {player_id: string}}) {
    const id = params.player_id;
    const response = await fetch(/*insert backend */);

    if (!response.ok) {
        throw new Error(response.statusText);
    }

    return response.json();
}