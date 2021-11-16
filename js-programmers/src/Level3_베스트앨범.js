
// 첫 풀이
// const solution = (genres, plays) => {
//   const obj = {};
//   for(let i = 0; i < genres.length; i++) {
//     const genre = genres[i];
//     obj[genre] = (obj[genre] || []).concat({ idx: i, play: plays[i] });
//   }

//   return Object.keys(obj)
//     .map(key => ({ key, total: obj[key].reduce((pre, cur) => pre + cur.play, 0) }))
//     .sort((a, b) =>  b.total - a.total)
//     .reduce((pre, cur) => {
//       if(obj[cur.key].length === 1) {
//         return pre.concat(obj[cur.key][0].idx);
//       }
//       const plays = obj[cur.key].sort((a, b) => (b.play === a.play) ? a.idx - b.idx : b.play - a.play);
//       return pre.concat(plays[0].idx, plays[1].idx);
//     }, []);
// };

// 개선
const solution = (genres, plays) => {
  const obj = {};
  for(let i = 0; i < genres.length; i++) {
    const genre = genres[i];
    obj[genre] = (obj[genre] || []).concat({ idx: i, play: plays[i] });
  }

  return Object.keys(obj)
    .map(key => ({ key, total: obj[key].reduce((pre, cur) => pre + cur.play, 0) }))
    .sort((a, b) =>  b.total - a.total)
    .reduce((pre, cur) => {
      const currentPlays = obj[cur.key].sort((a, b) => b.play - a.play);
      return pre.concat(currentPlays.map(item => item.idx).slice(0, 2))
    }, []);
};

const testData = [
  { genres: ["classic", "pop", "classic", "classic", "pop"], plays: [500, 600, 150, 800, 2500] },
  { genres: ["classic", "pop", "classic", "classic", "pop"], plays: [500, 2500, 150, 800, 2500] },
  { genres: ["classic", "classic", "classic"], plays: [700, 500, 700] },
  { genres: ["a", "b", "c"], plays: [700, 500, 800] },
]
  
testData.forEach(({genres, plays}) => {
  console.log(solution(genres, plays));
})