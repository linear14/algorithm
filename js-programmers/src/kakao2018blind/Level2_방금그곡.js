const solution = (m, musicinfos) => {
  const newM = m.replace(/C#/g, 'c').replace(/D#/g, 'd').replace(/F#/g, 'f').replace(/G#/g, 'g').replace(/A#/g, 'a').replace(/E#/g, 'e');

  const meta = musicinfos.map(music => { 
    const [start, end, title, melodiesStr] = music.split(',');
    const minStart = start.split(':').reduce((pre, cur, idx) => pre += idx === 0 ? 60 * Number(cur) : Number(cur), 0);
    const minEnd = end.split(':').reduce((pre, cur, idx) => pre += idx === 0 ? 60 * Number(cur) : Number(cur), 0);
    const repeat = minEnd - minStart + 1;

    const melodies = [];
  
    let temp = '';
    melodiesStr.split('').forEach((str, idx) => {
      if(str === '#') {
        switch(temp) {
          case 'C': temp = 'c'; break;
          case 'D': temp = 'd'; break;
          case 'F': temp = 'f'; break;
          case 'G': temp = 'g'; break;
          case 'A': temp = 'a'; break;
          case 'E': temp = 'e'; break;
          default: break;
        }
      }
      else {
        if(idx !== 0) {
          melodies.push(temp);
        }
        temp = str;
      }
    })
    melodies.push(temp);

    const result = [];
    for(let i = 0; i < repeat; i++) {
      result.push(melodies[i % melodies.length]);
    }

    return { start: minStart, length: repeat, title, melodies: result.join('') };
  })

  const candidate = meta.filter(item => item.melodies.indexOf(newM) >= 0)
  candidate.sort((a, b) => {
    if(a.length === b.length) {
      return a.start - b.start;
    }
    return b.length - a.length;
  })
  return candidate.length === 0 ? '(None)' : candidate[0].title;
}

const testData = [
  { m: "ABCDEFG", musicinfos: ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"] },
  { m: "CC#BCC#BCC#BCC#B", musicinfos: ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"] },
  { m: "ABC", musicinfos: ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"] },
  { m: "ABC", musicinfos: ["13:00,13:14,WORLD,ABCDEF", "12:00,12:14,HELLO,CDEFGAB"] },
];

testData.forEach(({ m, musicinfos }) => {
  console.log(solution(m, musicinfos));
});
