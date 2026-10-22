package com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.hypsilophodon;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class HypsilophodonAdultModel extends EntityModel<HypsilophodonRenderState> {
	private final ModelPart root;
	private final ModelPart butt;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart headlead;
	private final ModelPart head;
	private final ModelPart eyes;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart tailbase;
	private final ModelPart tailtip;
	private final ModelPart leftfoot;
	private final ModelPart leftthigh;
	private final ModelPart rightfoot;
	private final ModelPart rightthigh;

	final KeyframeAnimation idle;
	final KeyframeAnimation eat;
	final KeyframeAnimation walk;
	final KeyframeAnimation sitDown;
	final KeyframeAnimation sitting;
	final KeyframeAnimation standUp;
	final KeyframeAnimation blinking;

	final KeyframeAnimation scritch;

	public HypsilophodonAdultModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.butt = this.root.getChild("butt");
		this.chest = this.butt.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.headlead = this.neck.getChild("headlead");
		this.head = this.headlead.getChild("head");
		this.eyes = this.head.getChild("eyes");
		this.leftarm = this.chest.getChild("leftarm");
		this.rightarm = this.chest.getChild("rightarm");
		this.tailbase = this.butt.getChild("tailbase");
		this.tailtip = this.tailbase.getChild("tailtip");
		this.leftfoot = this.root.getChild("leftfoot");
		this.leftthigh = this.leftfoot.getChild("leftthigh");
		this.rightfoot = this.root.getChild("rightfoot");
		this.rightthigh = this.rightfoot.getChild("rightthigh");

		this.idle = HypsilophodonAdultAnimations.idle.bake(root);
		this.eat = HypsilophodonAdultAnimations.idle.bake(root);
		this.walk = HypsilophodonAdultAnimations.walk.bake(root);
		this.sitDown = HypsilophodonAdultAnimations.sit.bake(root);
		this.sitting = HypsilophodonAdultAnimations.sitting.bake(root);
		this.standUp = HypsilophodonAdultAnimations.stand.bake(root);
		this.blinking = HypsilophodonAdultAnimations.blink.bake(root);

		this.scritch = HypsilophodonAdultAnimations.scritch.bake(root);
	}
	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -4.0F));

		PartDefinition butt = root.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(8, 2).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 8.0F));

		PartDefinition chest = butt.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(15, 26).addBox(-1.5F, -1.5F, -5.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition headlead = neck.addOrReplaceChild("headlead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition head = headlead.addOrReplaceChild("head", CubeListBuilder.create().texOffs(11, 14).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition muzzle_r1 = head.addOrReplaceChild("muzzle_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(0, 26).addBox(1.51F, -0.5F, -1.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(7, 26).addBox(-1.51F, -0.5F, -1.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition leftarm = chest.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 29).addBox(0.0F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, -4.0F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition rightarm = chest.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(7, 29).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, -4.0F, -0.2618F, 0.0F, 0.2618F));

		PartDefinition tailbase = butt.addOrReplaceChild("tailbase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition cube_r1 = tailbase.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tailtip = tailbase.addOrReplaceChild("tailtip", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition cube_r2 = tailtip.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 25).addBox(-1.0F, -1.75F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition leftfoot = root.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(0, 9).addBox(0.5F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 9.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition leftthigh = leftfoot.addOrReplaceChild("leftthigh", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, -2.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightfoot = root.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(0, 16).addBox(0.5F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 9.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition rightthigh = rightfoot.addOrReplaceChild("rightthigh", CubeListBuilder.create().texOffs(20, 17).addBox(0.0F, -6.0F, -2.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.1745F, 0.0F, 0.0F));
		return LayerDefinition.create(modelData, 31, 37);
	}

	@Override
	public void setupAnim(HypsilophodonRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimationState.isStarted()){
			this.blinking.apply(state.blinkAnimationState, state.ageInTicks);
		}

		if(state.idleAnimationState.isStarted()){
			this.idle.apply(state.idleAnimationState, state.ageInTicks);
		}

		if(state.eatAnimationState.isStarted()){
			this.eat.apply(state.eatAnimationState, state.ageInTicks);
		}

		if(state.sittingdownAnimationState.isStarted()){
			this.sitDown.apply(state.sittingdownAnimationState, state.ageInTicks);
		}
		if(state.sitAnimationState.isStarted()){
			this.sitting.apply(state.sitAnimationState, state.ageInTicks);
		}
		if(state.standingupAnimationState.isStarted()){
			this.standUp.apply(state.standingupAnimationState, state.ageInTicks);
		}

		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 6f, 18f);

		//head
		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
	}
}