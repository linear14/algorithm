const solution = (genres, plays) => {
    const genreToPlayCount = new Map();
    const genreToSongList = new Map();
    
    for(let i = 0; i < genres.length; i++) {
        const [genre, playCount] = [genres[i], plays[i]];
        const prevPlayCount = genreToPlayCount.get(genre) || 0;
        genreToPlayCount.set(genre, prevPlayCount + playCount);
        
        const prevSongList = genreToSongList.get(genre) || [];
        genreToSongList.set(genre, prevSongList.concat({ play: playCount, idx: i }));   // concat 대체?
    }

    // 처음부터 이런 느낌으로 만들수는 없는건가?
    const totalCountToGenre = new Map();
    genreToPlayCount.forEach((totalCount, genre) => {
        totalCountToGenre.set(totalCount, genre);
    })
    
    return Array.from(genreToPlayCount.values())
        .sort((a, b) => b - a)
        .reduce((ans, playCount) => {
            const genre = totalCountToGenre.get(playCount);
            const songList = genreToSongList.get(genre);
            const sortedSongList = songList
                .sort((a, b) => a.play === b.play ? a.idx - b.idx : b.play - a.play)
                .slice(0, 2);
            ans.push(...(sortedSongList.map(item => item.idx)));
            return ans;
        }, []);
};