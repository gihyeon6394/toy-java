package os.process;

/**
 * 병행 프로세스에서 발생할 수 있는 문제점을 정의
 * 1.
 * 2. 생산자-소비자 문제
 * 3. 판독기-기록기 문제
 */
public class Concurrency {

    public static int mutex = 1;

    public static void main(String[] args) {


        case2();

    }

    /**
     * 2. 생산자-소비자 문제
     */
    private static void case2() {


        int success = 0;
        Semaphore s = new Semaphore();
        // 생산자
        while (success == 1) {

            s.pEmpty(); // 버퍼 사용 가능여부 확인
            s.pMutex();
            // 데이터 생산
            s.vMutex();
            s.vFull();
            success = 1;
        }
    
        //소비자
        success = 0;
        while (true) {
            s.pFull(); // 버퍼 사용 가능여부 확인
            s.pMutex();
            // 데이터 소비
            s.vMutex();
            s.vEmpty();
            success = 1;
        }

    }

    public static class Semaphore {

        private static int mutex  = 1;
        private static int empty = 10; // 현재 사용가능한 버퍼 사이즈

        private static int full = 0; // 현재 사용중인 버퍼 사이즈


        public synchronized void pMutex() {
            if (this.mutex > 0) {
                this.mutex--;
                // 프로세스 진행
            } else {
                // wait
            }
        }

        public synchronized void vMutex() {
            if (existWaitingProcess()) {
                // 해당 프로세스 진행
            } else {
                this.mutex++;
            }
        }

        public synchronized void pEmpty() {
            if (this.empty > 0) {
                this.empty--;
                // 프로세스 진행
            } else {
                // wait
            }
        }

        public synchronized void vEmpty() {
            if (existWaitingProcess()) {
                // 해당 프로세스 진행
            } else {
                this.empty++;
            }
        }

        public synchronized void pFull() {
            if (this.full > 0) {
                this.full--;
                // 프로세스 진행
            } else {
                // wait
            }
        }

        public synchronized void vFull() {
            if (existWaitingProcess()) {
                // 해당 프로세스 진행
            } else {
                this.full++;
            }
        }

        /**
         * 대기 중인 프로세스가 있는가
         */
        private static boolean existWaitingProcess() {
            return true;
        }

    }

    public static void publish() {
        while (true) {
            // .. 데이터 생산
        }
    }

    public static void subscribe() {
        while (true) {
            // .. 데이터 소비
        }
    }

}
