// 주제가 힙인데, 힙으로 안풀었음...ㅋㅋㅋ;;
// solution1은 내가 처음 생각한대로 풀어본 풀이고, 추후에 새롭게 올라갈 solution2는 힙을 이용한 풀이가 될 예정

const solution = (jobs) => {
  let finishedJobCount = 0;
  let lastStartTime = 0;
  const startTimeToWorkingTime = jobs.reduce((map, job) => {
      const [startTime, workingTime] = job;
      lastStartTime = Math.max(lastStartTime, startTime);
      map.set(startTime, (map.get(startTime) || []).concat(workingTime));
      return map;
  }, new Map())
  
  let nextFinishTime = 0;
  let totalPassedTime = 0;
  const waitingJobs = [];
  
  while(finishedJobCount < jobs.length) {
      while(waitingJobs.length === 0 && nextFinishTime <= lastStartTime) {
          if(startTimeToWorkingTime.has(nextFinishTime)) {
              const newJobs = startTimeToWorkingTime
                  .get(nextFinishTime)
                  .map(item => ({ startTime: nextFinishTime, workingTime: item }))
              waitingJobs.push(...newJobs)
          }
          else {
              nextFinishTime++;
          }
      }
      waitingJobs.sort((a, b) => b.workingTime - a.workingTime);
  
      const { startTime, workingTime } = waitingJobs.pop();
      totalPassedTime += (nextFinishTime - startTime + workingTime);
      
      // workingTime동안 들어올수 있는 모든 작업들 추가
      for(let i = 1; i <= workingTime; i++) {
          nextFinishTime++;
          if(startTimeToWorkingTime.has(nextFinishTime)) {
              const newJobs = startTimeToWorkingTime
                  .get(nextFinishTime)
                  .map(item => ({ startTime: nextFinishTime, workingTime: item }))
              waitingJobs.push(...newJobs)
          }
          
      }
      finishedJobCount++;
  }
  
  return Math.floor(totalPassedTime / jobs.length)
}