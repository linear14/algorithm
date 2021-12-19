const solution = dartResult => {
  const scores = [];
  
  let i = 0;
  let score = -1;
  while(i < dartResult.length) {
      const token = dartResult[i];
      if(Number.isInteger(Number(token))) {
          if(score === -1) {
              score = Number(token);
          }
          else {
              score = 10;
          }
          i++;
          continue;
      }
      if(score >= 0) {
          scores.push(score);
          score = -1;
      }
      
      if(['S', 'D', 'T'].includes(token)) {
          switch(token) {
              case 'D': scores[scores.length - 1] **= 2; break;
              case 'T': scores[scores.length - 1] **= 3; break;
              default: break;
          }
          i++;
          continue;
      }
      
      if(['*', '#'].includes(token)) {
          switch(token) {
              case '*': 
                  scores[scores.length - 1] *= 2;
                  if(scores.length > 1) {
                      scores[scores.length - 2] *= 2;
                  }
                  break;
              case '#':
                  scores[scores.length - 1] *= -1;
                  break;
              default: break;
          }
          i++;
          continue;
      }
  }
  
  return scores.reduce((pre, cur) => pre + cur, 0);
  
}