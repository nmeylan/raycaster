package com.nmeylan.core.game;

/**
 * Created by Nicolas on 15/11/2015.
 */
public abstract class GameLoop implements Runnable {

    private double NANO_SECOND = Math.pow(10, 9);

    private int framePerSecond;
    private double frameDelta;
    private int maxUpdateBetweenRender;
    private boolean running;
    private GameUpdater updater;
    private GameRenderer renderer;

    public GameLoop() {
        this.framePerSecond = 60;
        this.frameDelta = 0;
        this.maxUpdateBetweenRender = 5;
        this.running = false;
    }

    public GameLoop(GameUpdater updater, GameRenderer renderer) {
        this();
        this.updater = updater;
        this.renderer = renderer;
    }

    public synchronized void start() {
        new Thread(this).start();
        running = true;
    }

    public synchronized void stop() {
        running = false;
    }

    @Override
    public void run() {
        double timeBetweenUpdate = NANO_SECOND / framePerSecond;
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime = System.nanoTime();
        double targetTimeBetweenRenders = NANO_SECOND / framePerSecond;
        double now, renderDelta;
        int updateCount;
        while (running) {
            now = System.nanoTime();
            updateCount = 0;

            while (now - lastUpdateTime > timeBetweenUpdate && updateCount < this.maxUpdateBetweenRender) {
                this.updater.update(now - lastUpdateTime);
                lastUpdateTime += timeBetweenUpdate;
                updateCount++;
            }

            if (now - lastUpdateTime > timeBetweenUpdate) {
                lastUpdateTime = now - timeBetweenUpdate;
            }

            renderDelta = Math.min(1.0, (now - lastUpdateTime) / timeBetweenUpdate);
            this.renderer.render(renderDelta);
            lastRenderTime = now;

            // TODO FPS calculation here

            while (now - lastRenderTime < targetTimeBetweenRenders && now - lastUpdateTime < timeBetweenUpdate) {
                Thread.yield();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                now = System.nanoTime();
            }
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
