const solution = (begin, target, words) => {
  const isVisited = Array(words.length).fill(false);
  const q = [{ cur: begin, depth: 0 }];

  while(q.length > 0) {
    const { cur, depth } = q.shift();
    if(cur === target) {
      return depth;
    }

    for(let i = 0; i < words.length; i++) {
      if(!isVisited[i] && isValid(cur, words[i])) {
        isVisited[i] = true;
        q.push({ cur: words[i], depth: depth + 1});
      }
    }
  }

  return 0;
}

const isValid = (pre, cur) => {
  let count = 0;
  for(let i = 0; i < pre.length; i++) {
    if(pre[i] !== cur[i]) count++;
    if(count > 1) break;
  }
  return count === 1;
}

const testcase = [
  { 'begin': 'hit', 'target': 'cog', 'words': ["hot", "dot", "dog", "lot", "log", "cog"] },
  { 'begin': 'hit', 'target': 'cog', 'words': ["hot", "dot", "dog", "lot", "log"] },
];

testcase.forEach(({ begin, target, words }) => {
  console.log(solution(begin, target, words));
})